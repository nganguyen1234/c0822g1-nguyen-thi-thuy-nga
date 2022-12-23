package com.example.service;

import com.example.model.Music;

public interface IMusicService {
    boolean addNewSong(Music music);
    boolean updateSong(Music music);
}
