package com.keralakitchen.delivery.service;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.mapper.IMapper;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.repository.IUserRepository;
import com.keralakitchen.delivery.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IMapper userMapper;
    @Autowired
    IUserRepository userRepository;
    public Optional<Users> createUser(User user){
        Optional<Users> newUser = Optional.empty();
        Users userEntity = userRepository.save(userMapper.mapToUserEntity(user));
        newUser = Optional.of(userEntity);
        return newUser;
    }
}
