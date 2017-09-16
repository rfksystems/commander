package com.rfksystems.commander.exception;

public class CommandUnknownException extends CommanderException {
    public CommandUnknownException() {
    }

    public CommandUnknownException(final String message) {
        super(message);
    }

    public CommandUnknownException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommandUnknownException(final Throwable cause) {
        super(cause);
    }

    public CommandUnknownException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
