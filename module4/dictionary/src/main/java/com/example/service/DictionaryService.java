package com.example.service;

import com.example.repository.DictionaryRepository;

import java.util.Map;

public class DictionaryService {
    DictionaryRepository dictionaryRepository = new DictionaryRepository();

    public Map<String, String> getAllVocabulary() {
        return dictionaryRepository.getAllVocabulary();
    }

    public String translate(String word) {
        Map<String, String> map = dictionaryRepository.getAllVocabulary();
        for (String word1 : map.keySet()) {
            if (word.equals(word1)) {
                return map.get(word1);
            }
        }
        return "Không tìm thấy";
    }
}
