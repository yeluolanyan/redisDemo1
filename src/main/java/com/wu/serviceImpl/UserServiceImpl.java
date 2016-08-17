package com.wu.serviceImpl;

import com.wu.dao.UserDao;
import com.wu.model.User;
import com.wu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.currentTimeMillis;

/**
 * Created by MJN on 2016/8/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    protected UserDao userDao;

    @Override
    public boolean testAddUser(String id, String name, String password) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userDao.add(user);
    }

    /**
     * 批量新增 普通方式
     */
    @Override
    public String testAddUsers1(List<User> list) {
        long begin = currentTimeMillis();
        for (User user : list) {
            userDao.add(user);
        }
        long l = System.currentTimeMillis() -  begin;
        return "耗时："+l;
    }

    /**
     * 批量新增 pipeline方式
     */
    @Override
    public String testAddUsers2(List<User> list) {

        long begin = currentTimeMillis();
        boolean result = userDao.add(list);
        long l = currentTimeMillis() - begin;
        return "耗时："+l;
    }

    /**
     * 修改
     */
    @Override
    public void testUpdate(User user) {
        boolean result = userDao.update(user);
    }

    /**
     * 通过key删除单个
     */
    @Override
    public void testDelete(String key) {
        userDao.delete(key);
    }

    /**
     * 批量删除
     */
    @Override
    public void testDeletes(List<String> list) {
        userDao.delete(list);
    }

    /**
     * 获取
     */
    @Override
    public User testGetUser(String id) {
        User user = userDao.get(id);
        return user;
    }

}
