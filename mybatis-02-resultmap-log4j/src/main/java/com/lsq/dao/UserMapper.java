package com.lsq.dao;


import com.lsq.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author linshengqian
 */
public interface UserMapper {

    //根据id查询用户


    User selectUserById(int id);

    //查询全部用户

    List<User> selectUserLog();

    //选择全部用户实现分页

    List<User> selectUserLimit(Map<String,Integer> map);


    //选择全部用户RowBounds实现分页

    List<User> getUserByRowBounds();




}
