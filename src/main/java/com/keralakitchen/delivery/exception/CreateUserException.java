package com.keralakitchen.delivery.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserException extends Exception{
    private String message;
    public CreateUserException(String s){
        super(s);
        this.message = s;
    }
}
