package com.example.service;

import com.example.common.exception.InvalidCodeException;
import com.example.common.exception.OutOfBookException;
import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBook();
    Integer borrowBook(int id) throws OutOfBookException;
    boolean returnBook(int code) throws InvalidCodeException;
}
