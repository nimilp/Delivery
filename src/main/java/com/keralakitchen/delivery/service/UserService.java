package com.keralakitchen.delivery.service;

import com.keralakitchen.delivery.Collections;
import com.keralakitchen.delivery.entity.Users;
import com.keralakitchen.delivery.mapper.IMapper;
import com.keralakitchen.delivery.model.User;
import com.keralakitchen.delivery.repository.IUserRepository;
import com.keralakitchen.delivery.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class UserService implements IUserService {

    @Autowired
    IMapper userMapper;
    @Autowired
    IUserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Optional<Users> createUser(User user){
        Optional<Users> newUser = Optional.empty();
        Users userEntity = userRepository.save(userMapper.mapToUserEntity(user));
        newUser = Optional.of(userEntity);
        return newUser;
    }

    public List<User> getUsers(User user) {
        return mongoTemplate.find(
                (
                        query(where("")
                                .orOperator(where("firstName").is(user.getFirstName()),
                                        where("lastName").is(user.getLastName()))
                        )
                ),
                User.class, Collections.Users.value());
    }
}
