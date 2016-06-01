package com.rfksystems.commander.exception;

public class NoCommandGivenException extends Exception {
    public NoCommandGivenException() {
    }

    public NoCommandGivenException(String message) {
        super(message);
    }

    public NoCommandGivenException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCommandGivenException(Throwable cause) {
        super(cause);
    }

    public NoCommandGivenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
