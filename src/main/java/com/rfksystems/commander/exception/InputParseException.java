package com.rfksystems.commander.exception;

public class InputParseException extends Exception {
    public InputParseException() {
    }

    public InputParseException(String message) {
        super(message);
    }

    public InputParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputParseException(Throwable cause) {
        super(cause);
    }

    public InputParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
