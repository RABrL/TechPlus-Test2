package com.example.back.domain.exception;

public class QueryNotFoundException extends RuntimeException{
    public QueryNotFoundException() {
        super("Query Not Found");
    }

    public QueryNotFoundException(String message) {
        super(message);
    }
}
