package com.example.swagger.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.swagger.dao.UserDAO;
import com.example.swagger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author freedom
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public IPage<User> findByPage() {
        IPage<User> page = new Page<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return userDAO.page(page, queryWrapper);
    }

    public void saveOrUpdate(User user) {
        userDAO.saveOrUpdate(user);
    }

    public void deleteByIds(Collection<Long> ids) {
        userDAO.removeByIds(ids);
    }
}
