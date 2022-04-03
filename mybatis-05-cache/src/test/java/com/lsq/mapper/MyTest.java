package com.lsq.mapper;

import com.lsq.pojo.User;
import com.lsq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MyTest {

    @Test
    public void queryUserById01(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
    }       //默认开启一级缓存


    @Test
    public void queryUserById02(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
        session2.close();
    }       //每个sqlSession中的缓存相互独立


    @Test
    public void queryUserById03(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        HashMap map = new HashMap();
        map.put("name","林一");
        map.put("id",4);
        mapper.updateUser(map);

        session.commit();

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }       //增删改操作会清除一级缓存

    @Test
    public void queryUserById04(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        session.clearCache();//手动清除缓存

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1==user2);

        session.close();
    }


    @Test
    public void queryUserById05(){ //开启了二级缓存
        SqlSession session1 = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();

        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);
        session1.close();

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user1==user2);

        session2.close();
    }


}
