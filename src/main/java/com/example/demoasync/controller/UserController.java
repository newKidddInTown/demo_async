package com.example.demoasync.controller;

import com.example.demoasync.exception.UserNotFoundException;
import com.example.demoasync.model.User;
import com.example.demoasync.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/edit")
    public void editUser(@RequestBody User user) {

        if (Strings.isBlank(user.getId())) {
            throw new UserNotFoundException();
        }
        userRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);
        userRepository.save(user);
    }

    @GetMapping("/actives")
    public List<User> getActiveUser() {
        return userRepository.findByIsDeletedFalse();
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userRepository.getAllUserWithOnlyNames();
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

