package com.workshop8.redsocial.Amistad.dto;

public class ResponseErrorDTO {

    private String message;
    private Integer code;

    public ResponseErrorDTO(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

}
