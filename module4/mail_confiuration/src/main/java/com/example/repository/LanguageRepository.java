package com.example.repository;

import java.util.ArrayList;
import java.util.List;

public class LanguageRepository {
   public static List<String> languageList = new ArrayList<>();
   static {
       languageList.add("English");
       languageList.add("Vietnamese");
       languageList.add("Japanese");
       languageList.add("Chinese");
   }
}
