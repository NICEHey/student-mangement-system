package com.itevent.service;

import com.itevent.domain.Users;

import java.util.List;

public interface UserService {

    /**
     * 通过用户名和密码查找管理员
     * @return
     * @param users
     */
    Users login(Users users);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<Users> findAll();

    /**
     * 通过id删除用户信息
     */
    void delUser(String id);

    /**
     * 添加用户信息
     * @param user
     */
    void addUser(Users user);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(Users user);

    /**
     * 通过id寻找用户
     * @param id
     * @return
     */
    Users finUser(String id);
}
