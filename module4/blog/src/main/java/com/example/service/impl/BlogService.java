package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public boolean addNewBlog(Blog blog) {
        try {
            blogRepository.save(blog);
        } catch (IllegalArgumentException e) {
return false;
        } catch (OptimisticLockingFailureException e) {
            return false;
        }
return true;
    }

    public boolean updateBlog(Blog blog) {
        try {
            blogRepository.save(blog);
        } catch (IllegalArgumentException e) {
            return false;
        } catch (OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    public boolean removeBlog(int id) {
        try {
            blogRepository.deleteById(id);
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findBlogById(id);
    }

}
