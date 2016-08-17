package com.wu.controller;

import com.wu.model.User;
import com.wu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJN on 2016/8/17.
 */
@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/add",method={RequestMethod.GET})
    @ResponseBody
    public String add(String id ,String name){
         userService.testAddUser(id,name,"XXX");
        return "ok";
    }

    @RequestMapping(value="/adds",method={RequestMethod.GET})
    @ResponseBody
    public String adds(){
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5000; i++) {
            User u = new User();
            u.setId("a"+i);
            u.setName("a--"+i);
            users.add(u);
        }
        return userService.testAddUsers1(users);
    }

    @RequestMapping(value="/query/{id}",method={RequestMethod.GET})
    @ResponseBody
    public String queryMember(@PathVariable("id")String id){
        User u = userService.testGetUser(id);
        return u.getId()+" ::: "+u.getName();
    }

    @RequestMapping(value="/del/{id}",method={RequestMethod.GET})
    @ResponseBody
    public String deleteMmber(@PathVariable("id")String id){

        userService.testDelete(id);
        return "true";
    }
}
