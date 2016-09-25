package com.racing.controller.vo;

import com.racing.model.po.User;

import java.util.List;

public class UserVo extends PageVo{
    public List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}