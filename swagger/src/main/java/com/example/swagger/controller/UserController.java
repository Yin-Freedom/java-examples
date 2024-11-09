package com.example.swagger.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.api.CommonResult;
import com.example.swagger.entity.User;
import com.example.swagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("findByPage")
    @PostMapping("/findByPage")
    public CommonResult<IPage<User>> findByPage() {
        return CommonResult.success(userService.findByPage());
    }

    @ApiOperation("saveOrUpdate")
    @PostMapping("/saveOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return CommonResult.success(null);
    }

    @ApiOperation("deleteByIds")
    @PostMapping("/deleteByIds")
    public CommonResult deleteByIds(@RequestBody List<Long> ids) {
        userService.deleteByIds(ids);
        return CommonResult.success(null);
    }
}
