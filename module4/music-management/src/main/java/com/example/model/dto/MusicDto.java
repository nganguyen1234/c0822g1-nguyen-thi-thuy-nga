package com.example.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MusicDto {
    @NotBlank(message = "tên bài hát không thể để trống")
    @Max(value = 800, message = "tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "\\w+")
    private String song;

    @NotBlank(message = "tên nghệ sĩ không thể để trống")
    @Max(value = 10, message = "tên nghệ sĩ không được vượt quá 10 ký tự")
    @Pattern(regexp = "\\w+")
    private String artist;

    @NotBlank(message = "thể loại nhạc không thể để trống")
    @Max(value = 1000, message = "thể loại nhạc không được vượt quá 1000 ký tự")
    @Pattern(regexp = "[\\w,]+")
    private String genre;

    public MusicDto() {
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
