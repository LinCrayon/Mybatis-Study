package com.lsq.mapper;

import com.lsq.pojo.User;
import com.lsq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getAllUser() {
        SqlSession session = MybatisUtils.getSession();
        //本质上利用了jvm的动态代理机制
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = mapper.getAllUser();
        for (User user : users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void selectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);

        session.close();
    }

    @Test
    public void addUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = new User(6, "林圣铅", "123456");
        mapper.addUser(user);

        session.close();
    }
    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(6, "小薇", "loev");
        mapper.updateUser(user);
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        session.close();
    }
}

//注意点：增删改一定记得对事务的处理