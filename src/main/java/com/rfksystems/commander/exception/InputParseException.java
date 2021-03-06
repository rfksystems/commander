package com.rfksystems.commander.exception;

public class InputParseException extends CommanderException {
    public InputParseException() {
    }

    public InputParseException(final String message) {
        super(message);
    }

    public InputParseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InputParseException(final Throwable cause) {
        super(cause);
    }

    public InputParseException(
            final String message,
            final Throwable cause,
            final boolean enableSuppression,
            final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
