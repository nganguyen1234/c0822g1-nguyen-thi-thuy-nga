package com.example.controller;

import com.example.model.MailConfiguration;
import com.example.repository.ConfigurationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ConfigurationController {
    private ConfigurationRepository configurationRepository = new ConfigurationRepository();

    @GetMapping("/show-form")
    public String showSettingForm(Model model) {
        List<Integer> pageSizeList = configurationRepository.getAllPageSize();
        List<String> languageList = configurationRepository.getAllLanguage();
        MailConfiguration mailConfiguration = configurationRepository.getMailConfiguration();
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("mailConfiguration",mailConfiguration);
        return "configuration";
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, @ModelAttribute("mailConfiguration") MailConfiguration mailConfiguration) {
        configurationRepository.updateConfigurationsList(mailConfiguration);
        redirectAttributes.addFlashAttribute("mess", "Successfully updated");
        redirectAttributes.addFlashAttribute("mailConfiguration",mailConfiguration);
        return "redirect:/show-form";
    }
}
