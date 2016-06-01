package com.rfksystems.commander.exception;

public class RuntimeArgumentException extends Exception {
    public RuntimeArgumentException() {
    }

    public RuntimeArgumentException(String message) {
        super(message);
    }

    public RuntimeArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeArgumentException(Throwable cause) {
        super(cause);
    }

    public RuntimeArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
