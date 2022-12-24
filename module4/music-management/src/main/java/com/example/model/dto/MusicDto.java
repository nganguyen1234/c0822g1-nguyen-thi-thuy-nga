package com.example.model.dto;

import javax.validation.constraints.*;

public class MusicDto {
    private int id;
    @NotBlank(message = "tên bài hát không thể để trống")
    @Size(max = 800, message = "tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "\\w+", message = "tên bài hát không thể bao gồm kí tự đặc biệt ")
    private String song;

    @NotBlank(message = "tên nghệ sĩ không thể để trống")
    @Size(max = 10, message = "tên nghệ sĩ không được vượt quá 10 ký tự")
    @Pattern(regexp = "\\w+", message = "tên nghệ sĩ không thể bao gồm kí tự đặc biệt ")
    private String artist;

    @NotBlank(message = "thể loại nhạc không thể để trống")
    @Size(max = 1000, message = "thể loại nhạc không được vượt quá 1000 ký tự")
    @Pattern(regexp = "[\\w,]+", message = "thể loại nhạc không thể bao gồm kí tự đặc biệt ")
    private String genre;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
