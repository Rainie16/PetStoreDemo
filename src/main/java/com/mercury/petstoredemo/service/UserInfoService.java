package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.User;
import com.mercury.petstoredemo.bean.UserInfo;
import com.mercury.petstoredemo.dao.UserDao;
import com.mercury.petstoredemo.dao.UserInfoDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;


    public List<UserInfo> getAll() {return userInfoDao.findAll(); }

    public UserInfo getByUsername (String name) {
        System.out.println(userDao.findByUsername(name).getUserInfo());
        return userDao.findByUsername(name).getUserInfo();
        }

    public UserInfo getById(int id) { return userInfoDao.findById(id).get(); }

    public Response addUserInfo(UserInfo userInfo, Authentication authentication) {
        try {
            User user = userDao.findByUsername(authentication.getName());
            userInfo.setUser(user);
            userInfoDao.save(userInfo);
            user.setUserInfo(userInfo);
            userDao.save(user);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response updateUserInfo(UserInfo userInfo) {
        UserInfo ud = userInfoDao.findById(userInfo.getId()).get();
        userInfo.setUser(ud.getUser());
        ud = userInfo;
        userInfoDao.save(ud);
        return new Response(true);
    }

}
