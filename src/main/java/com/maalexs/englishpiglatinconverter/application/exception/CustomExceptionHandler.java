package com.maalexs.englishpiglatinconverter.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Handle custom excpetions
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handle empty english text exception
     *
     * @param eete Exception object
     * @param request Request object
     * @return Response with error message
     */
    @ExceptionHandler(EmptyEnglishTextException.class)
    public ResponseEntity<String> handleEmptyEnglishTextException(EmptyEnglishTextException eete,
                                                                  HttpServletRequest request) {
        return new ResponseEntity<>("English text param is required", HttpStatus.BAD_REQUEST);
    }
}

