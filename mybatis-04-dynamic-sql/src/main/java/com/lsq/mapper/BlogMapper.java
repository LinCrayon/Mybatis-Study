package com.lsq.mapper;

import com.lsq.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author linshengqian
 */
public interface BlogMapper {

    //新增一个博客

    int addBlog(Blog blog);

    //需求1

    List<Blog> queryBlogIf(Map map);


    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);


    List<Blog> queryBlogForeach(Map map);

}
