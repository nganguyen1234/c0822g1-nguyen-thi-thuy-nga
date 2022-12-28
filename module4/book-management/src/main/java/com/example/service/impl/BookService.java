package com.example.service.impl;

import com.example.common.exception.InvalidCodeException;
import com.example.common.exception.OutOfBookException;
import com.example.model.Book;
import com.example.model.History;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import com.example.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(rollbackFor = Throwable.class)
@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IHistoryService historyService;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Integer borrowBook(int id) throws OutOfBookException {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return -1;
        }
        if (book.getQuantity() == 0) {
            throw new OutOfBookException("");
        }
        book.setQuantity(book.getQuantity() - 1);
        int code = (int) Math.floor(((Math.random() * 89999) + 10000));
        History history = new History();
        history.setBookId(book.getId());
        history.setCode(code);
        historyService.addHistory(history);
        try {
            bookRepository.save(book);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return null;
        }
        return code;
    }

    public boolean returnBook(int code) throws InvalidCodeException {
        Optional<History> history = historyService.getBookByCode(code);
        if (history.isPresent()) {
            int bookId = history.get().getBookId();
            Book book = bookRepository.findById(bookId).get();
            book.setQuantity(book.getQuantity() + 1);
            try {
                bookRepository.save(book);
            } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
                return false;
            }
            historyService.deleteHistory(code);
            return true;
        } else {
            throw new InvalidCodeException("Mã số không hợp lệ");
        }
    }

}
