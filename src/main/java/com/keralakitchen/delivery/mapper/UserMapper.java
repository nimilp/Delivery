package com.keralakitchen.delivery.mapper;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.model.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements IMapper{


    public Users mapToUserEntity(User user){
        return new Users(null, user.getFirstName(), user.getLastName(), user.getType());
    }

    @Override
    public List<User> mapToUsers(List<Users> users) {
        if (!users.isEmpty()) {
            return users.stream().map(user -> new User(user.getId(), user.getFirstName(), user.getLastName(),"")).collect(Collectors.toList());

        }
        return Collections.emptyList();
    }
}
