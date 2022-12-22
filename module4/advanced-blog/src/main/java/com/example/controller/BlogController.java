package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/show-list")
    public String showList(Model model) {
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogList", blogList);
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        return "blog/list";
    }

    @GetMapping(value = "/show-detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Blog blog = (Blog) blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping(value = "/show-add-form")
    public String showAddForm(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/add";
    }

    @PostMapping(value = "/add")
    public String addNewBlog(RedirectAttributes redirectAttributes, Blog blog) {
        boolean check = blogService.addNewBlog(blog);
        String mess;
        if (check) {
            mess = "Was successfully added";
        } else {
            mess = "Failed to add";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

    @GetMapping(value = "/show-edit-form/{id}")
    public String showEditForm(Model model, @PathVariable("id") int id) {
        Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping(value = "/edit")
    public String editBlog(RedirectAttributes redirectAttributes, Blog blog) {
        boolean check = blogService.updateBlog(blog);
        String mess;
        if (check) {
            mess = "Was successfully edited";
        } else {
            mess = "Failed to edit";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

    @PostMapping("/delete")
    public String deleteBlog(RedirectAttributes redirectAttributes, Blog blog) {
        boolean check = blogService.removeBlog(blog.getId());
        String mess;
        if (check) {
            mess = "Was successfully deleted";
        } else {
            mess = "Failed to delete";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

}
