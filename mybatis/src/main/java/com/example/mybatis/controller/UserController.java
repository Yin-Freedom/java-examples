package com.example.mybatis.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.api.CommonResult;
import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author freedom
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findByPage")
    public CommonResult<IPage<User>> findByPage() {
        return CommonResult.success(userService.findByPage());
    }

    @PostMapping("/saveOrUpdate")
    public CommonResult saveOrUpdate(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return CommonResult.success(null);
    }

    @PostMapping("/deleteByIds")
    public CommonResult deleteByIds(@RequestBody List<Long> ids) {
        userService.deleteByIds(ids);
        return CommonResult.success(null);
    }
}
