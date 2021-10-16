package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.User;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() { return userService.getAll(); }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) { return userService.getById(id); }

    @GetMapping("/name/{name}")
    public User getByName(@PathVariable String name) { return userService.getByName(name); }

    @PostMapping
    public Response addUser(@RequestBody User user) { return userService.register(user); }

    @PutMapping
    public Response changeUser(@RequestBody User user, Authentication authentication) {
        return userService.changePassword(user, authentication);
    }

    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable int id) { return userService.deleteUser(id); }

}
