package org.booty;

/**
 * @author Enrico Costanzi
 */
public class BootyException extends RuntimeException {

    public BootyException() {
    }

    public BootyException(String message) {
        super(message);
    }

    public BootyException(String message, Throwable cause) {
        super(message, cause);
    }

    public BootyException(Throwable cause) {
        super(cause);
    }

    public BootyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
