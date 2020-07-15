package com.itevent.dao;

import com.itevent.domain.Users;

import java.util.List;

public interface UserDao {

    Users findAdm(String username, String password);

    List<Users> findAll();

    void delUser(int i);

    void addUser(Users user);

    void updateUser(Users user);

    Users findUser(int id);
}
