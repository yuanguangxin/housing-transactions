package com.yyy.housingtransactions.controller;

import com.yyy.housingtransactions.model.User;
import com.yyy.housingtransactions.model.common.CommonObjectResponse;
import com.yyy.housingtransactions.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonObjectResponse login(@RequestBody User u) {
        User user = userService.login(u);
        if (user == null) {
            return CommonObjectResponse.notOk("用户名不存在或密码错误");
        }
        return CommonObjectResponse.ok(user);
    }

    @PostMapping("/register")
    public CommonObjectResponse register(@RequestBody User u) {
        User user = userService.selectByUsername(u.getUsername());
        if (user != null) {
            return CommonObjectResponse.notOk("用户名已存在");
        }
        User record = new User();
        record.setUsername(u.getUsername());
        record.setPassword(u.getPassword());
        userService.insert(record);
        return CommonObjectResponse.ok(record);
    }

    @PostMapping("/updateUserInfo")
    public CommonObjectResponse updateUserInfo(@RequestBody User u) {
        User user = userService.selById(u.getId());
        user.setEmail(u.getEmail());
        user.setIntro(u.getIntro());
        user.setSex(u.getSex());
        user.setTel(u.getTel());
        userService.update(user);
        return CommonObjectResponse.ok(user);
    }
}
