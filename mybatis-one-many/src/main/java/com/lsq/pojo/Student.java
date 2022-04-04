package com.lsq.pojo;

import lombok.Data;

/**
 * @author linshengqian
 */

@Data
public class Student {
    private int id;
    private String name;
    //多个学生可以是同一个老师，即多对一
    private Teacher teacher;

}
