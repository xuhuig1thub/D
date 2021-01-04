package com.a.artifact.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2021-01-03 2:00
 */
@RestControllerAdvice
@Slf4j
public class MExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String hrthd(Exception e) {
        log.error(e.getMessage(), e);

        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> allErrors = ex.getAllErrors();
            ObjectError error = allErrors.get(0);
            String defaultMessage = error.getDefaultMessage();
            return defaultMessage;
        }  else {
            return "error";
        }
    }
}