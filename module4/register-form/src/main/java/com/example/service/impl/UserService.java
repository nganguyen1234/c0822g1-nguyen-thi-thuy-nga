package com.example.service.impl;

import com.example.model.User;
import com.example.repository.IUserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean addNewUser(User user) {
        try {
            userRepository.save(user);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }
}
