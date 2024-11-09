package com.example.swagger.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.swagger.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author freedom
 */
@Repository
public class UserDAO extends ServiceImpl<UserMapper, User> {
}
