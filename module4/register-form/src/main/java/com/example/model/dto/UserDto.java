package com.example.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class UserDto {
    private int id;

    @NotBlank(message = "Không được để trống")
    private String firstName;

    @NotBlank(message = "Không được để trống")
    private String lastName;

    @Pattern(regexp = "\\d{10}",message = "số điện thoại gồm 10 chữ số")
    private String phoneNumber;

    @Min(value = 18, message = "Bạn chưa đủ tuổi quy định")
    private int age;

    @Pattern(regexp = "[a-zA-Z]+\\w+@\\w+(\\.\\w+)+",message = "email cần đúng định dạng, ex: abc123@gmail.com")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
