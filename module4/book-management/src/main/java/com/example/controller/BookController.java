package com.example.controller;

import com.example.common.exception.InvalidCodeException;
import com.example.common.exception.OutOfBookException;
import com.example.model.Book;
import com.example.model.History;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping(value = "/show-list")
    public String showList(Model model) {
        List<Book> bookList = bookService.getAllBook();
        History history = new History();
        model.addAttribute("bookList", bookList);
        model.addAttribute("history", history);
        return "list";
    }

    @GetMapping(value = "/borrow-book/{id}")
    public String borrowBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) throws OutOfBookException {
        Integer code = bookService.borrowBook(id);
        String mess;
        if (code != null) {
            mess = "Successfully borrowed, code: " + code;
        } else {
            mess = "Failed to borrow";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

    @PostMapping(value = "/return-book")
    public String returnBook(History history, RedirectAttributes redirectAttributes) throws InvalidCodeException {
        boolean check = bookService.returnBook(history.getCode());
        String mess;
        if (check) {
            mess = "Successfully returned";
        } else {
            mess = "Failed to return";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }
}
