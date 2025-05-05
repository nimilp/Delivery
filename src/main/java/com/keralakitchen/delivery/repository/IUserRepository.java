package com.keralakitchen.delivery.repository;

import com.keralakitchen.delivery.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository  extends MongoRepository<Users, String>{
}
