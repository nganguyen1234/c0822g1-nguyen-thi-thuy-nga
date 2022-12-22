package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public boolean addNewBlog(Blog blog) {
        try {
            if (blogRepository.findByTitle(blog.getTitle()) != null) {
                throw new SQLDataException();
            }
            blogRepository.save(blog);
        } catch (IllegalArgumentException | OptimisticLockingFailureException | SQLDataException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        if (!blogRepository.existsById(blog.getId())) {
            return false;
        }
        try {
            blogRepository.save(blog);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeBlog(int id) {
        try {
            blogRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Blog> findBlogById(int id) {
        return blogRepository.findById(id);
    }

}
