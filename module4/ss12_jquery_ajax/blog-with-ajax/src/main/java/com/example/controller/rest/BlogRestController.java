package com.example.controller.rest;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
@CrossOrigin("*")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

//    @GetMapping(value = "/show-list")
//    public ResponseEntity<List<Blog>> getAllBlog() {
//        Pageable pageable = PageRequest.of()
//        List<Blog> blogList = blogService.findAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping(value = "/show-detail/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findBlogById(id).orElse(null);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping(value = "/show-list-by-category")
    public ResponseEntity<Page<Blog>> getBlogsByCategory(@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<Blog> blogPage;
        Pageable pageable = PageRequest.of(0, size);
        if (id==0) {
            blogPage = blogService.getAllBlog(pageable);
        } else {
            blogPage = blogService.findBlogByCategory(id, pageable);
        }
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }


}
