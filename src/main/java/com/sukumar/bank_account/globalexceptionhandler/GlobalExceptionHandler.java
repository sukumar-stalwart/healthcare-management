package com.sukumar.bank_account.globalexceptionhandler;

import com.sukumar.bank_account.accountmanagement.exception.AccountNotFoundException;
import com.sukumar.bank_account.accountmanagement.exception.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.validation.BindingResultUtils.getBindingResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(MethodArgumentNotValidException e, HttpServletRequest req){
        Map<String, String> errorMap = e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError->FieldError.getField(), FieldError->FieldError.getDefaultMessage(),(oldvalue,newvalue)->oldvalue+","+newvalue));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> exceptionHandling(AccountNotFoundException e, HttpServletRequest req){
        ErrorResponseDto errors = ErrorResponseDto.builder().path(req.getRequestURI()).message("Account not found").timeStamp(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}
