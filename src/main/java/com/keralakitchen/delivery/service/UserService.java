package com.keralakitchen.delivery.service;

import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.mapper.IMapper;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.repository.IUserRepository;
import com.keralakitchen.delivery.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
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

//    @Query(value = "{ 'firstName' : ?0 , 'lastName':?1}", fields="{ 'firstName' : 1, 'lastName' : 2}")
    public List<User> getUsers(User user) {
        Users userEntity = userMapper.mapToUserEntity(user);
        List<Users> users = userRepository.getUsers(userEntity, user.getFirstName(), user.getLastName());
        return userMapper.mapToUsers(users);
    }
}
