package com.workshop8.redsocial.Amistad.exceptions;

import org.springframework.http.HttpStatusCode;

public class AmistadApiException extends RuntimeException {

    private HttpStatusCode code;

    public AmistadApiException(String message) {
        super(message);
    }

    public AmistadApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmistadApiException(String message, Throwable cause, HttpStatusCode code) {
        super(message, cause);
        this.code = code;
    }

    public AmistadApiException(String message, HttpStatusCode code) {
        super(message);
        this.code = code;
    }

    public HttpStatusCode getCode() {
        return code;
    }
}
