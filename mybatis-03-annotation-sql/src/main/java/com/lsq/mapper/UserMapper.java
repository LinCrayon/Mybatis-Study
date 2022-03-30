package com.lsq.mapper;

import com.lsq.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author linshengqian
 */
public interface UserMapper {
    //查询全部用户

    @Select("select id,name,pwd from user")
    public List<User> getAllUser();

    //根据id查询用户

    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    //添加一个用户

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    //修改一个用户

    @Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
    int updateUser(User user);

    //根据id删除用

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id")int id);


}
