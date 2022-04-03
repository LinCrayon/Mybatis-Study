package com.lsq.mapper;

import com.lsq.pojo.Student;
import com.lsq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testGetStudents(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudent();

        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }

}
