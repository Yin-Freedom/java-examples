package com.example.search.dao;

import com.example.search.entity.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author freedom
 */
public interface EsUserRepository extends ElasticsearchRepository<EsUser, Long> {
}
