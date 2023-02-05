package com.uc.exception;

import com.uc.exception.base.BaseException;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException() {
        super("Bulunamadı!");
    }
}
