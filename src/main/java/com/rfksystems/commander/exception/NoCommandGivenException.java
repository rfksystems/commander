package com.rfksystems.commander.exception;

public class NoCommandGivenException extends CommanderException {
    public NoCommandGivenException() {
    }

    public NoCommandGivenException(final String message) {
        super(message);
    }

    public NoCommandGivenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoCommandGivenException(final Throwable cause) {
        super(cause);
    }

    public NoCommandGivenException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
