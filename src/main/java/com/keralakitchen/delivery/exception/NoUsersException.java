package com.keralakitchen.delivery.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoUsersException extends Exception{

    private String message;
    public NoUsersException(String s){
        super(s);
        this.message = s;

    }
}
