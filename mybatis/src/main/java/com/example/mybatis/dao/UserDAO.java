package com.example.mybatis.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author freedom
 */
@Repository
public class UserDAO extends ServiceImpl<UserMapper, User> {
}
