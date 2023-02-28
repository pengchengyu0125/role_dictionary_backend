package com.rbc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbc.entity.User;
import com.rbc.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public List<User> findAll() {
        List<User> all = list();
        return all;
    }

    public Boolean insertOrUpdate(User user) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        user.setCreate_time(time);
        user.setModify_time(time);
        return saveOrUpdate(user);
    }

    public boolean delete(User user) {
        return removeById(user);
    }

    public IPage<User> selectPage(Integer pageNo, Integer pageSize, String username, String email) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
        queryWrapper.like("email", email);
        return page(page, queryWrapper);
    }

    public Long getTotal() {
        return getTotal();
    }
}
