package com.ytech.restapi.service;

import com.ytech.restapi.dao.User;

import java.util.Collection;

public interface IUserService {

    public abstract void createUser(User user);

    public abstract void updateUser(String id, User user);

    public abstract void deleteUser(String id);

    public abstract Collection<User> getUsers();
}
