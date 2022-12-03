package ru.netology.moneytransferservice.exception;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.moneytransferservice.entity.ErrorOfOperation;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> size(MethodArgumentNotValidException e) {
        var gson = new Gson();
        var err = new ErrorOfOperation();
        err.setMessage(e.getFieldError().getDefaultMessage());
        err.setId(400);
        String ex = gson.toJson(err);
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> errorOfServer(RuntimeException e) {
        var gson = new Gson();
        var err = new ErrorOfOperation();
        err.setMessage(e.getMessage());
        err.setId(500);
        String ex = gson.toJson(err);
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
