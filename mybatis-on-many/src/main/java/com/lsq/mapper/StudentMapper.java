package com.lsq.mapper;

import com.lsq.pojo.Student;

import java.util.List;

/**
 * @author linshengqian
 */
public interface StudentMapper {

    //获取所有学生及对应老师的信息

    public List<Student> getStudent();


}
