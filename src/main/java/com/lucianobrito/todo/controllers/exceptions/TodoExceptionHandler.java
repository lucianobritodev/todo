package com.lucianobrito.todo.controllers.exceptions;

import com.lucianobrito.todo.domain.services.exceptions.BusinessRuleException;
import com.lucianobrito.todo.domain.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class TodoExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ResponseError.Field> fields = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new ResponseError.Field(name, message));
        }

        var errorMessage = "One or more fields are invalid. Fill in correctly and try again.";
        var error = getCustomError(errorMessage, status.value(), request);
        error.setFields(fields);

        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var error = getCustomError(ex.getMessage(), status.value(), request);
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Object> handleBusinessRule(BusinessRuleException ex , WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var error = getCustomError(ex.getMessage(), status.value(), request);
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    private ResponseError getCustomError(String errorMessage, Integer statusCode, WebRequest request) {
        var error = new ResponseError();
        error.setStatus(statusCode);
        error.setDateTime(ZonedDateTime.now());
        error.setError(errorMessage);
        error.setPath(((ServletWebRequest) request).getRequest().getRequestURI());
        return error;
    }

}
