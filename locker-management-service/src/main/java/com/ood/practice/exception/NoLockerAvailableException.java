package com.ood.practice.exception;

public class NoLockerAvailableException extends RuntimeException {

    public NoLockerAvailableException(String message) {
        super(message);
    }
}
