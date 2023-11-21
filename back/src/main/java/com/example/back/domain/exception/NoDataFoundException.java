package com.example.back.domain.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super("No Data Found");
    }

    public NoDataFoundException(String message) {
        super(message);
    }

}
