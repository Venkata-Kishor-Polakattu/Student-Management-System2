package com.nk.studentmanagementsystem.exception;

public class EmailExists extends  RuntimeException {
    public EmailExists(String message) {
        super(message);
    }
}
