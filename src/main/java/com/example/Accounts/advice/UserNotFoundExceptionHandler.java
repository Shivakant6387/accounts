package com.example.Accounts.advice;

import com.example.Accounts.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR )
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String ,String> handlerInvalidException(UserNotFoundException e){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",e.getMessage());
        return errorMap;
    }
}
