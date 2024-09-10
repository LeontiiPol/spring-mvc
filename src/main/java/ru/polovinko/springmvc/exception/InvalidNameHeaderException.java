package ru.polovinko.springmvc.exception;

public class InvalidNameHeaderException extends RuntimeException {

    public InvalidNameHeaderException(String message) {
        super(message);
    }
}
