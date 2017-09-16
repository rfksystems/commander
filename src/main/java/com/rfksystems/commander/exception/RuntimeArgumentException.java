package com.rfksystems.commander.exception;

public class RuntimeArgumentException extends CommanderException {
    public RuntimeArgumentException() {
    }

    public RuntimeArgumentException(final String message) {
        super(message);
    }

    public RuntimeArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RuntimeArgumentException(final Throwable cause) {
        super(cause);
    }

    public RuntimeArgumentException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
