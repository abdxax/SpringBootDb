package com.example.dbex3.ExceptionHandling;

public class ApiException extends RuntimeException{
    public ApiException(String msg){
        super(msg);
    }
}
