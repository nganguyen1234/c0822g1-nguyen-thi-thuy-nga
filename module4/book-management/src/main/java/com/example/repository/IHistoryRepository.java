package com.example.repository;

import com.example.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History,Integer> {

}
