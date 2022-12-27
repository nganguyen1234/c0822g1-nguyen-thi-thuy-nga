package com.example.service;

import com.example.model.History;

import java.util.Optional;

public interface IHistoryService {
     Optional<History> getBookByCode(int code);
     boolean deleteHistory(int code);
    boolean addHistory(History history);
}
