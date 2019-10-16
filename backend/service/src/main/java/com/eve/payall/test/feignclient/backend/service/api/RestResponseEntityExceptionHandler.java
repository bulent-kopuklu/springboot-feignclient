package com.eve.payall.test.feignclient.backend.service.api;

import com.eve.payall.test.feignclient.backend.service.api.exceptions.ResourceNotFoundException;
import com.eve.payall.test.feignclient.backend.service.api.exceptions.model.ErrorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = { ResourceNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request)
    {
        return handleExceptionInternal(ex,
                new ErrorObject(123, ex.getMessage(), LocalDateTime.now()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
                );
    }

    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request)
    {
        logger.error("500 Status Code", ex);
        final ErrorObject error = new ErrorObject(123, ex.getMessage(), LocalDateTime.now());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }


}
