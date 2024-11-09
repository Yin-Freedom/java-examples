package com.example.search.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.search.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author freedom
 */
@Repository
public class UserDAO extends ServiceImpl<UserMapper, User> {
}
