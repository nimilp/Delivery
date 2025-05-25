package com.keralakitchen.delivery.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NoDataException extends Exception{

    private String message;
    public NoDataException(String s){
        super(s);
        this.message = s;

    }
}
