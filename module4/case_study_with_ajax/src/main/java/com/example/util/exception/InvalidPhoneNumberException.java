package com.example.util.exception;

public class InvalidPhoneNumberException extends Exception{
    public InvalidPhoneNumberException(String mess){
        super(mess);
    }
}
