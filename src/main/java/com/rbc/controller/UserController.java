package com.rbc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rbc.entity.User;
import com.rbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //search user
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    //inert and update user
    @PostMapping
    public boolean insertOrUpdate(@RequestBody User user) {
        System.out.print(user.getId());
        return userService.insertOrUpdate(user);
    }

    //delete user
    @DeleteMapping
    public boolean delete(@RequestBody User user) {
        return userService.delete(user);
    }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNo,
                                @RequestParam Integer pageSize,
                                @RequestParam(required = false) String username,
                                @RequestParam(required = false) String email) {

        pageNo = (pageNo - 1) * pageSize;
        IPage<User> users = userService.selectPage(pageNo, pageSize, username, email);
        return users;
    }

}
