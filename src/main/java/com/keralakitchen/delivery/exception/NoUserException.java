package com.keralakitchen.delivery.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoUserException extends Exception{
    private String message;
    public NoUserException(String s){
        super(s);
        this.message = s;
    }
}
