package com.duyhelloworld.baedungfirstwebapp.exception;

public class BookIdMissmatchException extends Exception {
    public BookIdMissmatchException(String mess) {
        super(mess);
    }
    public BookIdMissmatchException() {
        super();
    }
}
