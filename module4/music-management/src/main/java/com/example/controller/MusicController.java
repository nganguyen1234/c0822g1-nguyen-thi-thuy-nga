package com.example.controller;

import com.example.model.Music;
import com.example.model.dto.MusicDto;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping(value = "/show-add-form")
    String showAddForm(Model model){
        MusicDto musicDto = new MusicDto();
        model.addAttribute("musicDto",musicDto);
        return "add";
    }

    @PostMapping(value = "/add-music")
    String addNewSong(@Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "show-add-form";
        }else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto,music);
            boolean check = musicService.addNewSong(music);
            String mess;
            if (check){
                mess = "Thêm mới thành công";
            }else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess",mess);
            return "redirect:/show-add-form";
        }
    }

}
