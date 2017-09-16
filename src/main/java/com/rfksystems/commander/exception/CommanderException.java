package com.rfksystems.commander.exception;

public abstract class CommanderException extends Exception{
    public CommanderException() {
    }

    public CommanderException(final String message) {
        super(message);
    }

    public CommanderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommanderException(final Throwable cause) {
        super(cause);
    }

    public CommanderException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
