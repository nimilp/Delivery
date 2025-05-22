package com.keralakitchen.delivery.handlers;

import com.keralakitchen.delivery.exception.CreateItemException;
import com.keralakitchen.delivery.exception.CreateUserException;
import com.keralakitchen.delivery.exception.NoDataException;
import com.keralakitchen.delivery.exception.NoUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoDataException.class)
    public String handleNoDataException(NoDataException ex){
        return ex.getMessage();
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NoUserException.class)
//    public String handleNoUserException(NoUserException ex){
//        return ex.getMessage();
//    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CreateItemException.class )
    public String handleCreateItemException(CreateItemException ex){
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex){
        return ex.getMessage();
    }
}
