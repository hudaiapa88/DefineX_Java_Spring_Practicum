package com.uc.weather.exception;

import com.uc.weather.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class NotFountException extends BaseException {
    public NotFountException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
