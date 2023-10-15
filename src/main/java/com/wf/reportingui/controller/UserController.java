package com.wf.reportingui.controller;

import com.wf.reportingui.entity.User;
import com.wf.reportingui.entity.UserOutput;
import com.wf.reportingui.repo.UserRepository;
import com.wf.reportingui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User saveUser = userRepository.save(user);
        return new ResponseEntity<>(saveUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserOutput> userLogin(@RequestBody User user) {
        UserOutput userOutput = userService.validateCredentials(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(userOutput,HttpStatus.OK);
    }
}

