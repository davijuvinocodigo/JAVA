package com.exception.exceptions;

public class BookBadRequestException extends RuntimeException {

    public BookBadRequestException() {
        super();
    }

    public BookBadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookBadRequestException(final String message) {
        super(message);
    }

    public BookBadRequestException(final Throwable cause) {
        super(cause);
    }
}