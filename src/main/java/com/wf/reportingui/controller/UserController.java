package com.wf.reportingui.controller;

import com.wf.reportingui.entity.User;
import com.wf.reportingui.entity.UserOutput;
import com.wf.reportingui.repo.UserRepository;
import com.wf.reportingui.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserOutput> addUser(@RequestBody User user) {
        User saveUser = userRepository.save(userService.encodePassward(user));
        UserOutput userOutput = new UserOutput(saveUser.getId(),saveUser.getEmail(), saveUser.getUsername(),true,saveUser.getRole());
        return new ResponseEntity<>(userOutput, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UserOutput> userLogin(@RequestBody User user) {
        UserOutput userOutput = userService.validateCredentials(user);
        return new ResponseEntity<>(userOutput, HttpStatus.OK);
    }
}

