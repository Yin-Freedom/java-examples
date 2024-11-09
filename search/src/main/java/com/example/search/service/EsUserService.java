package com.example.search.service;

import com.example.search.dao.EsUserRepository;
import com.example.search.entity.EsUser;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author freedom
 */
@Service
public class EsUserService {

    @Autowired
    private EsUserRepository esUserRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public void save(EsUser esUser) {
        esUserRepository.save(esUser);
    }

    public void saveAll(Collection<EsUser> collection) {
        esUserRepository.saveAll(collection);
    }

    public void deleteByIds(Collection<Long> ids) {
        esUserRepository.deleteAllById(ids);
    }

    public Iterator<EsUser> findAll() {
        return esUserRepository.findAll().iterator();
    }

    public Page<EsUser> findByKeyword(String keyword, Integer pageNum, Integer pageSize, String sort, String dir) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        //分页
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        if (StringUtils.isBlank(keyword)) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchAllQuery());
        } else {
            List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("userName", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(10)));
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("nickName", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(5)));
            FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[filterFunctionBuilders.size()];
            filterFunctionBuilders.toArray(builders);
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2);
            nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
        }
        // 排序
        if (StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(dir)) {
            nativeSearchQueryBuilder.withSorts(SortBuilders.fieldSort(sort).order(SortOrder.ASC.toString().equals(dir) ? SortOrder.ASC : SortOrder.DESC));
        }
        nativeSearchQueryBuilder.withSorts(SortBuilders.scoreSort().order(SortOrder.DESC));
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        SearchHits<EsUser> searchHits = elasticsearchRestTemplate.search(searchQuery, EsUser.class);
        if (searchHits.getTotalHits() <= 0) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }
        List<EsUser> searchList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        return new PageImpl<>(searchList, pageable, searchHits.getTotalHits());
    }
}
