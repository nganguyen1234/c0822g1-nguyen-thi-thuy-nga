package com.example.service;

import com.example.model.Music;

import java.util.Optional;

public interface IMusicService {
    boolean addNewSong(Music music);
    boolean updateSong(Music music);
    Optional<Music> findById(int id);
}
