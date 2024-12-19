package com.challenge.Foro.exceptions;

public class InvalidAuthException extends RuntimeException {

    public InvalidAuthException(String message) {
        super(message);
    }
}