package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.UserInfo;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.UserInfoService;
import com.mercury.petstoredemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-details")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    private UserInfo getById(@PathVariable int id) {
        return userInfoService.getById(id);
    }

    @PostMapping
    public Response postUserDetails(@RequestBody UserInfo userInfo, Authentication authentication) {
        return userInfoService.addUserInfo(userInfo, authentication);
    }

    @PutMapping
    public Response putUserInfos(@RequestBody UserInfo userInfo) { return userInfoService.updateUserInfo(userInfo); }

}
