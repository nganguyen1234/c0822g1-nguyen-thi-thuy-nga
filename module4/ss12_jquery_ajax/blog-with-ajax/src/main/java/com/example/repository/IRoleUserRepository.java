package com.example.repository;

import com.example.model.Role;
import com.example.model.RoleUser;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleUserRepository extends JpaRepository<RoleUser, Integer> {
    List<RoleUser> findByUser(User user);
}
