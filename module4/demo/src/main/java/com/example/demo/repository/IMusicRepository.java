package com.example.demo.repository;

import com.example.demo.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
    Music findBySong(String song);
}
