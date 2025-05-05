package com.keralakitchen.delivery;

public enum Collections {
    Users("users");
    private final String value;
    Collections(String value){
        this.value = value;
    };
    public String value(){
        return this.value;
    }
}
