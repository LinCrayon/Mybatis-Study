package com.lsq.mapper;

import com.lsq.pojo.Blog;
import com.lsq.utils.IDUtil;
import com.lsq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("林圣铅");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void testQueryBlogIf(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Mybatis如此简单");
        map.put("author","林圣铅");
        List<Blog> blogs = mapper.queryBlogIf(map);

        System.out.println(blogs);

        session.close();
    }


    @Test
    public void testUpdateBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","林圣铅");
        map.put("id","9d6a763f5e1347cebda43e2a32687a77");

        mapper.updateBlog(map);


        session.close();
    }



    @Test
    public void testQueryBlogChoose(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","Java如此简单");
        map.put("author","林圣铅");
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        System.out.println(blogs);

        session.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        session.close();
    }

}



