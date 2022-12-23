package com.example.demo.service.impl;


import com.example.demo.model.Music;
import com.example.demo.repository.IMusicRepository;
import com.example.demo.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public boolean addNewSong(Music music) {
        if (musicRepository.findBySong(music.getSong()) != null) {
            return false;
        }
        try {
            musicRepository.save(music);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSong(Music music) {
        if (!musicRepository.existsById(music.getId())) {
            return false;
        }
        try {
            musicRepository.save(music);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Music> findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public List<Music> getAllSong() {
        return musicRepository.findAll();
    }
}
