package com.digitec.factura.controller;

import com.digitec.factura.model.ValidationErrorResponse;
import com.digitec.factura.model.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            validationErrorResponse.getViolations().add(new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return validationErrorResponse;
    }
}
