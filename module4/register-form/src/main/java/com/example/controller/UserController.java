package com.example.controller;

import com.example.model.User;
import com.example.model.dto.UserDto;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/show-add-form")
    public String showAddForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "registerForm";
    }

    @PostMapping(value = "/add-user")
    public String addNewUser(@Validated UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "registerForm";

        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            Boolean check = userService.addNewUser(user);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
        }
        return "redirect:/show-add-form";
    }

}
