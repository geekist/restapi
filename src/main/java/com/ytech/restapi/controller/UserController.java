package com.ytech.restapi.controller;

import com.ytech.restapi.dao.User;
import com.ytech.restapi.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    IUserService userService;

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody User user) {
        userService.updateUser(id, user);
        return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createProduct(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }

    @ApiOperation(value = "用户测试",notes = "用户测试notes")
    @GetMapping(value = "/users")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}
