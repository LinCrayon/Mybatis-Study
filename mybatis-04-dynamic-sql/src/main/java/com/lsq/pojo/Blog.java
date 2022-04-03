package com.lsq.pojo;

import lombok.*;

import java.util.Date;

/**
 * @author linshengqian
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

}
