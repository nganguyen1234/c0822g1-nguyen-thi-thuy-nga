package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    boolean addNewBlog(Blog blog);
    boolean updateBlog(Blog blog);
    boolean removeBlog(int id);
    Blog findBlogById(int id);

}
