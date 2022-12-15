package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryService();

    @RequestMapping("/dictionary-form")
    public String showDictionaryForm(Model model) {
        Map<String, String> map = dictionaryService.getAllVocabulary();
        model.addAttribute("map", map);
        return "dictionary";
    }

    @RequestMapping("/translate")
    public String translate(Model model,  String word) {
        model.addAttribute("word", word);
        model.addAttribute("meaning", dictionaryService.translate(word));
        return "dictionary";
    }
}
