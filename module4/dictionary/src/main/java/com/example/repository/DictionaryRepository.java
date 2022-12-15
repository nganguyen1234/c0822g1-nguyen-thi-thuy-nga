package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("begin", "bắt đầu");
        map.put("call", "gọi");
        map.put("come", "đến");
        map.put("do", "làm");
        map.put("find", "tìm kiếm");
        map.put("get", "có được");
        map.put("give", "cho");
        map.put("go", "đi");
        map.put("hear", "nghe");
        map.put("help", "giúp");
        map.put("keep", "giữ");
        map.put("know", "biết");
    }

    public Map<String, String> getAllVocabulary() {
        return map;
    }

    public String translate(String word) {
        Map<String, String> map = getAllVocabulary();
        for (String word1 : map.keySet()) {
            if (word.equals(word1)) {
                return map.get(word1);
            }
        }
        return "Không tìm thấy";
    }
}
