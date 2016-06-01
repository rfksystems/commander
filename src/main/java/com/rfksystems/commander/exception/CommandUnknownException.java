package com.rfksystems.commander.exception;

public class CommandUnknownException extends Exception {
    public CommandUnknownException() {
    }

    public CommandUnknownException(String message) {
        super(message);
    }

    public CommandUnknownException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandUnknownException(Throwable cause) {
        super(cause);
    }

    public CommandUnknownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
