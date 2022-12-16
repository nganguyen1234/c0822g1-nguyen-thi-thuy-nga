package com.example.repository;

import com.example.model.MailConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationRepository {
   private MailConfiguration oldMailConfiguration = new MailConfiguration("English",13,true,"nga");

    public List<Integer> getAllPageSize(){
        return PageSizeRepository.pageSizeList;
    }
    public List<String> getAllLanguage(){
        return LanguageRepository.languageList;
    }
public MailConfiguration getMailConfiguration(){
        return oldMailConfiguration;
}

    public void updateConfigurationsList(MailConfiguration newMailConfiguration){
        oldMailConfiguration.setLanguage(newMailConfiguration.getLanguage());
        oldMailConfiguration.setPageSize(newMailConfiguration.getPageSize());
        oldMailConfiguration.setSpamFilter(newMailConfiguration.isSpamFilter());
        oldMailConfiguration.setSignature(newMailConfiguration.getSignature());
    }
}
