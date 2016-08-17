package com.wu.service;

import com.wu.model.User;

import java.util.List;

/**
 * Created by MJN on 2016/8/17.
 */
public interface UserService {
    boolean testAddUser(String id, String name, String password);

    String testAddUsers1(List<User> list);

    String testAddUsers2(List<User> list);

    void testUpdate(User user);

    void testDelete(String key);

    void testDeletes(List<String> list);

    User testGetUser(String id);
}
