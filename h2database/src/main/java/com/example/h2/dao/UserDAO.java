package com.example.h2.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.h2.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author freedom
 */
@Repository
public class UserDAO extends ServiceImpl<UserMapper, User> {
}
