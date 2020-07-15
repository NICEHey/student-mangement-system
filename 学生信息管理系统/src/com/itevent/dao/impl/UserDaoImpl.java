package com.itevent.dao.impl;


import com.itevent.dao.UserDao;
import com.itevent.domain.Users;
import com.itevent.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Users findAdm(String username,String password) {

        try {
            //要和数据库中的名字保持一致
            String sql = "select * from user where username = ? and password = ?";
            Users adm = template.queryForObject(sql, new BeanPropertyRowMapper<Users>(Users.class), username, password);

            return adm;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Users> findAll() {

        //1.定义sql
        String sql = "select * from user";

        //2.执行sql
        //这样写是不行的，但至于为什么不能这样写，我也不清楚。
       /* List<Users> list = template.queryForList(sql,Users.class);*/

        List<Users> users = template.query(sql, new BeanPropertyRowMapper<Users>(Users.class));

        return users;
    }

    @Override
    public void delUser(int i) {
        String sql = "delete from user where id=?";
        template.update(sql,i);
    }

    @Override
    public void addUser(Users user) {

        //1.定义一个添加的sql
/*
        String sql = "INSERT  INTO `user`(`id`,`name`,`gender`,`age`,`address`,`cls`,`tel`) VALUES (NULL,?,?,?,?,?);";
*/
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null )";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getCls(),user.getTel());
    }

    @Override
    public void updateUser(Users user) {

        //1.定义一个更新的sql
        String sql = "update user set user.name = ? ,user.gender = ? ,user.age = ?, user.address = ? ,user.cls = ? ,user.tel = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getCls(), user.getTel(), user.getId());

    }

    @Override
    public Users findUser(int id) {

        //1.定义一个查找的sql
        String sql = "select * from user where id = ?";
        Users users = template.queryForObject(sql, new BeanPropertyRowMapper<Users>(Users.class), id);
        return users;
    }
}
