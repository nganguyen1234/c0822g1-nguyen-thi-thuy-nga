package com.example.controller.rest;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blog")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/show-list")
    public ResponseEntity<List<Blog>> getAllBlog() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping(value = "/show-detail/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findBlogById(id).orElse(null);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping(value = "/show-list-by-category/{id}")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable("id") int id) {
        List<Blog> blogList = blogService.findBlogByCategory(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
