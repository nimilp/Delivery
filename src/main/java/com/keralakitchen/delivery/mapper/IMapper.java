package com.keralakitchen.delivery.mapper;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.model.User;

import java.util.List;

public interface IMapper {
    Users mapToUserEntity(User user);
    List<User> mapToUsers(List<Users> users);
}
