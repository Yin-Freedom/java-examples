package com.example.search.controller;

import com.example.common.api.CommonResult;
import com.example.search.entity.EsUser;
import com.example.search.service.EsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author freedom
 */
@Api
@RestController
@RequestMapping("/api/es_user")
public class EsUserController {

    @Autowired
    private EsUserService esUserService;

    @ApiOperation("findByPage")
    @PostMapping("/findByPage")
    public CommonResult<Page<EsUser>> findByPage(String keyword) {
        return CommonResult.success(esUserService.findByKeyword(keyword, 1, 20, null, null));
    }

    @ApiOperation("saveOrUpdate")
    @PostMapping("/saveOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody EsUser esUser) {
        esUserService.save(esUser);
        return CommonResult.success(null);
    }

    @ApiOperation("deleteByIds")
    @PostMapping("/deleteByIds")
    public CommonResult deleteByIds(@RequestBody List<Long> ids) {
        esUserService.deleteByIds(ids);
        return CommonResult.success(null);
    }
}
