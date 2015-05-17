package com.epam.validator.exception;

/**
 * Created by swift-seeker-89717 on 14.05.2015.
 */
public class BedFieldValueException extends RuntimeException {

    public BedFieldValueException() {
    }

    public BedFieldValueException(String message) {
        super(message);
    }

    public BedFieldValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public BedFieldValueException(Throwable cause) {
        super(cause);
    }

    public BedFieldValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
