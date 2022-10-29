package com.transporters.truckservice.errorhandler;

import com.transporters.truckservice.dto.RestError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody RestError
     handleConflictRequest(Exception e) {
        return new RestError( HttpStatus.CONFLICT, LocalDateTime.now(), e.getLocalizedMessage());
    }


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody RestError
     handleEntityNotFoundRequest(Exception e) {
        return new RestError( HttpStatus.NOT_FOUND, LocalDateTime.now(), e.getLocalizedMessage());
    }
}
