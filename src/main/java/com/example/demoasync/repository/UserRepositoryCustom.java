package com.example.demoasync.repository;

import com.example.demoasync.model.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> getAllUserWithOnlyNames();
}
