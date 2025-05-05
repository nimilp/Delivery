package com.keralakitchen.delivery.service.service;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<Users> createUser(User user);
    List<User> getUsers(User user);
}
