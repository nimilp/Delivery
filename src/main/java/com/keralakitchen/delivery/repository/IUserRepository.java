package com.keralakitchen.delivery.repository;

import com.keralakitchen.delivery.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository  extends MongoRepository<Users, String>{
    @Query(value = "{ 'firstName' : ?0 }", fields="{ 'firstName' : 1}")
    List<Users> getUsers(Users user, String firstName);
}
