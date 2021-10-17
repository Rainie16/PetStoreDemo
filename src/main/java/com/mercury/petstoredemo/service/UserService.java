package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.Role;
import com.mercury.petstoredemo.bean.User;
import com.mercury.petstoredemo.dao.UserDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User getById(int id) {
        return userDao.findById(id).get();
    }

    public User getByName(String name) {
        return userDao.findByUsername(name);
    }

    public Response register(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(new Role(2));
            userDao.save(user);
            return new Response(true, 200, "Register successfully!");
        } catch(Exception e) {
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response changePassword(User user, Authentication authentication) {
        if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
            User u = userDao.findByUsername(user.getUsername());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(u);
        } else {
            return new Response(false);
        }
        return new Response(true);
    }

    public boolean isAdmin(Collection<? extends GrantedAuthority> roles) {
        boolean isAdmin = false;
        for(GrantedAuthority role : roles) {
            if(role.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
            }
        };
        return isAdmin;
    }

    public Response deleteUser(int id) {
        if(userDao.findById(id).get() != null) {
            userDao.deleteById(id);
            return new Response(true);
        } else {
            return new Response(false, 400, "User cannot find!");
        }
    }
}
