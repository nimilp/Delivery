package com.keralakitchen.delivery.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

//@Document
@AllArgsConstructor
public class Users {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String type;
}
