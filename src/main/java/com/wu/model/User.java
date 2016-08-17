package com.wu.model;

import java.io.Serializable;

/**
 * Created by MJN on 2016/8/17.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1959528436584592183L;


    private String id;

    private String name;

    private String password;

    public User(){};
    public User(String id,String name,String password){
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
