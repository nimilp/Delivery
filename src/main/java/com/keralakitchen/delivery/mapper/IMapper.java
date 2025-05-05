package com.keralakitchen.delivery.mapper;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.model.User;

public interface IMapper {
    Users mapToUserEntity(User user);
}
