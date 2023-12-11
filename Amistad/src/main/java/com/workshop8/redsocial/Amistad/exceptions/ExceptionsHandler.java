package com.workshop8.redsocial.Amistad.exceptions;

import com.workshop8.redsocial.Amistad.dto.ResponseErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = { AmistadApiException.class })
    public ResponseEntity<ResponseErrorDTO> handleRedSocialApiException(AmistadApiException e) {
        ResponseErrorDTO res = new ResponseErrorDTO(e.getMessage(), e.getCode().value());

        return new ResponseEntity<ResponseErrorDTO>(res, e.getCode());
    }
}
