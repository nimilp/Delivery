package com.keralakitchen.delivery.mapper;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMapper{


    public Users mapToUserEntity(User user){
        return new Users(null, user.getFirstName(), user.getLastName(), user.getType());
    }
}
