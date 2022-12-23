package com.example.demo.service;

import com.example.demo.model.Music;

import java.util.List;
import java.util.Optional;

public interface IMusicService {
    boolean addNewSong(Music music);
    boolean updateSong(Music music);
    Optional<Music> findById(int id);
    List<Music> getAllSong();
}
