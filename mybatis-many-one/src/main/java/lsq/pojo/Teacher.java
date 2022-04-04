package lsq.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author linshengqian
 */
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
