package com.keralakitchen.delivery.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateItemException extends Exception{
    private String message;
    public CreateItemException(String s){
        super(s);
        this.message = s;
    }
}
