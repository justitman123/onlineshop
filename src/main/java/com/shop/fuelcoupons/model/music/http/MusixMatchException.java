package com.shop.fuelcoupons.model.music.http;

@SuppressWarnings("serial")
public class MusixMatchException extends Exception {

    /**
     * Constructs a new exception with the specified message.
     *
     * @param message
     *            the reason for the exception
     */
    public MusixMatchException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified message and wrapped
     * exception.
     *
     * @param message
     *            the reason for the exception
     * @param cause
     *            the internal exception that caused this exception
     */
    public MusixMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
