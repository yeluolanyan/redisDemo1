package com.wu.dao;

import com.wu.model.User;

import java.util.List;

/**
 * Created by MJN on 2016/8/17.
 */
public interface UserDao {
    boolean add(User user);

    boolean add(List<User> list);

    void delete(String key);

    void delete(List<String> keys);

    boolean update(User user);

    User get(String keyId);
}
