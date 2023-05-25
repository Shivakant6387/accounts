package com.example.Accounts.advice;

import com.example.Accounts.Dto.AccountsDto;
import com.example.Accounts.Exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class UserNotFoundExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<AccountsDto> handleAllExceptions(Exception ex, WebRequest request){
        AccountsDto errorDetails=new AccountsDto (LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<AccountsDto>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<AccountsDto> handleUserNotFoundException(Exception ex, WebRequest request){
        AccountsDto errorDetails=new AccountsDto(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<AccountsDto>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
