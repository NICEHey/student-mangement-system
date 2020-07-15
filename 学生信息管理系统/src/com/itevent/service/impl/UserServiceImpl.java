package com.itevent.service.impl;

import com.itevent.dao.UserDao;
import com.itevent.dao.impl.UserDaoImpl;
import com.itevent.domain.Users;
import com.itevent.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {


    private UserDao dao = new UserDaoImpl();

    @Override
    public Users login(Users users) {

        return dao.findAdm(users.getUsername(),users.getPassword());
    }

    @Override
    public List<Users> findAll() {
        return dao.findAll();
    }

    @Override
    public void delUser(String id) {
        int i = Integer.parseInt(id);
        dao.delUser(i);
    }

    @Override
    public void addUser(Users user) {
        dao.addUser(user);
    }

    @Override
    public void updateUser(Users user) {
        dao.updateUser(user);
    }

    @Override
    public Users finUser(String id) {
        return dao.findUser(Integer.parseInt(id));
    }
}
