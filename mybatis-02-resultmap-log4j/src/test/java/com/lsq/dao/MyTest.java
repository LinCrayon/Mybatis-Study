package com.lsq.dao;

import com.lsq.pojo.User;
import com.lsq.utils.MybatisUtils;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    @Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();  //获取SqlSession连接
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void selectUserLog() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserLog();
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    //LIMIT分页
    //分页查询 , 两个参数startIndex , pageSize
    @Test
    public void testSelectUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",(currentPage-1)*pageSize); //起始位置 =(当前页面 - 1)* 页面大小
        map.put("pageSize",pageSize);

        List<User> users = mapper.selectUserLimit(map);

        for (User user: users){
            System.out.println(user);
        }

        session.close();
    }

//RowBounds分页
    @Test
    public void testUserByRowBounds(){
        SqlSession session = MybatisUtils.getSession();

        int currentPage = 2;
        int pageSize = 2;
        RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);

        //通过session.**方法进行传递rowBounds

        List<User> users = session.selectList("com.lsq.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

}
