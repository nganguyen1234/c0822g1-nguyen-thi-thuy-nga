package com.example.service.impl;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public boolean addNewSong(Music music) {
        try {
            musicRepository.save(music);
        }catch (
                IllegalArgumentException | OptimisticLockingFailureException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSong(Music music) {
        try {
            musicRepository.save(music);
        }catch (
                IllegalArgumentException | OptimisticLockingFailureException e){
            return false;
        }
        return true;
    }
}
