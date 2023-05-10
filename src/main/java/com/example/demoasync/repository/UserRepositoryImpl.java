package com.example.demoasync.repository;

import com.example.demoasync.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUserWithOnlyNames() {

        Query query = new Query();
        query.fields().include("name");
        query.fields().exclude("_id");
        return mongoTemplate.find(query, User.class);
    }
}
