package com.example.demoasync.repository;

import com.example.demoasync.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom{
    List<User> findByIsDeletedFalse();
}
