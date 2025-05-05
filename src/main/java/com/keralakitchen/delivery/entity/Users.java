package com.keralakitchen.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

//@Document
@Data
@AllArgsConstructor
public class Users {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String type;
}
