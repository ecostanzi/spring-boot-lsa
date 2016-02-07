package org.encos.lsa.exceptions;

/**
 * @author Enrico Costanzi
 */
public class LsaException extends RuntimeException {

    public LsaException() {
    }

    public LsaException(String message) {
        super(message);
    }

    public LsaException(String message, Throwable cause) {
        super(message, cause);
    }

    public LsaException(Throwable cause) {
        super(cause);
    }

    public LsaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
