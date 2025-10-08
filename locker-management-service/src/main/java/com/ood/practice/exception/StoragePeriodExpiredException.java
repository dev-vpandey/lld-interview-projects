package com.ood.practice.exception;

public class StoragePeriodExpiredException extends RuntimeException {

    public StoragePeriodExpiredException(String message) {
        super(message);
    }

}
