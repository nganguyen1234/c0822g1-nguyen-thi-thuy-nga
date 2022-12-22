package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IBlogService {
    Page<Blog> searchTitle(String title, Pageable pageable);
    Page<Blog> findBlogByCategory(int id, Pageable pageable);
    boolean addNewBlog(Blog blog);
    boolean updateBlog(Blog blog);
    boolean removeBlog(int id);
    Optional<Blog> findBlogById(int id);
}
