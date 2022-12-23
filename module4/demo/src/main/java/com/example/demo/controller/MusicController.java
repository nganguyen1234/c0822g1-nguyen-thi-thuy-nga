package com.example.demo.controller;


import com.example.demo.model.Music;
import com.example.demo.model.dto.MusicDto;
import com.example.demo.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/show-list")
    String showList(Model model) {
        List<Music> musicList = musicService.getAllSong();
        model.addAttribute("musicList", musicList);
        return "list";
    }

    @GetMapping(value = "/show-add-form")
    String showAddForm(Model model) {
        MusicDto musicDto = new MusicDto();
        model.addAttribute("musicDto", musicDto);
        return "add";
    }

    @PostMapping(value = "/add-music")
    String addNewSong(@Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "show-add-form";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            boolean check = musicService.addNewSong(music);
            String mess;
            if (check) {
                mess = "Thêm mới thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/show-add-form";
        }
    }

    @GetMapping(value = "/show-edit-form/{id}")
    String showEditForm(Model model, @PathVariable("id") int id) {
        Optional<Music> music = musicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    String editSongInfo(@Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(music, musicDto);
            boolean check = musicService.updateSong(music);
            String mess;
            if (check) {
                mess = "Đã chỉnh sửa thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/show-edit-form";
        }
    }
}
