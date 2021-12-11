package com.CSC280.Lab2Api.Controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.openmbean.KeyAlreadyExistsException;


@ControllerAdvice
public class MyExceptionOverride extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<MyExceptionMessage> somethingWentWrong(IllegalArgumentException ex){
        System.out.println("somethingWentWrong()");
        MyExceptionMessage myEx = new MyExceptionMessage(ex.getMessage(), 400);
        return new ResponseEntity<MyExceptionMessage>(myEx, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<MyExceptionMessage> somethingWentWrongRuntime(RuntimeException ex){
        System.out.println("somethingWentWrongRuntime()");
        MyExceptionMessage myEx = new MyExceptionMessage(ex.getMessage(), 418);
        return new ResponseEntity<MyExceptionMessage>(myEx, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NeuNotAuthorizedException.class)
    public final ResponseEntity<MyExceptionMessage> somethingWentWrongCustom(RuntimeException ex){
        System.out.println("somethingWentWrongRuntime()");
        MyExceptionMessage myEx = new MyExceptionMessage(ex.getMessage(), 403);
        return new ResponseEntity<MyExceptionMessage>(myEx, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(KeyAlreadyExistsException.class)
    public final ResponseEntity<MyExceptionMessage> keyExists(RuntimeException ex){
        System.out.println("Key Already Exists");
        MyExceptionMessage myEx = new MyExceptionMessage(ex.getMessage(), 420);
        return new ResponseEntity<MyExceptionMessage>(myEx, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
