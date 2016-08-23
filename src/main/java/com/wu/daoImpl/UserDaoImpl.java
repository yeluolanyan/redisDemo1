package com.wu.daoImpl;

import com.wu.dao.RedisGeneratorDao;
import com.wu.dao.UserDao;
import com.wu.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJN on 2016/8/17.
 */
@Repository(value="userDao")
public class UserDaoImpl extends RedisGeneratorDao<String,User> implements UserDao {
    /**
     * 新增
     * @param user
     * @return
     */
    @Override
    public boolean add(User user) {
        redisTemplate.opsForValue().set(user.getId(),user);
        return true;
    }

    /**
     * 批量新增 使用pipeline方式
     *@param list
     *@return
     */
    @Override
    public boolean add(final List<User> list) {
        Assert.notEmpty(list);
        for (User user:list) {
            redisTemplate.opsForValue().set(user.getId(),user);
        }
        return true;
    }

    /**
     * 删除
     * @param key
     */
    @Override
    public void delete(String key) {
        List<String> list = new ArrayList<String>();
        list.add(key);
        delete(list);
    }

    /**
     * 删除多个
     * @param keys
     */
    @Override
    public void delete(List<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @Override
    public boolean update(final User user) {
        String key = user.getId();
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }else {
            redisTemplate.opsForValue().set(user.getId(),user);
        }
        return true;
    }

    /**
     * 通过key获取
     * @param keyId
     * @return
     */
    @Override
    public User get(final String keyId) {
        User u = redisTemplate.opsForValue().get(keyId);
        return u;
    }
}
