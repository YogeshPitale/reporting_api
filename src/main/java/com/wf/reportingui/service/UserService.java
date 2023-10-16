package com.wf.reportingui.service;

import com.wf.reportingui.entity.User;
import com.wf.reportingui.entity.UserOutput;
import com.wf.reportingui.repo.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User encodePassward(User user){
        String password = Base64.encodeBase64String(user.getPassword().getBytes());
        User passwordEncUser = new User();
        passwordEncUser.setId(user.getId());
        passwordEncUser.setEmail(user.getEmail());
        passwordEncUser.setUsername(user.getUsername());
        passwordEncUser.setPassword(password);
        passwordEncUser.setRole(user.getRole());
        return passwordEncUser;
    }

    public UserOutput validateCredentials(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        UserOutput userOutput = new UserOutput();
        if (existingUser != null && existingUser.getPassword().equals(encodePassward(user).getPassword())) {
            userOutput.setUserId(existingUser.getId());
            userOutput.setUsername(existingUser.getUsername());
            userOutput.setSuccess(true);
            userOutput.setRole(existingUser.getRole());

        } else {
            userOutput.setSuccess(false);
            userOutput.setRole(null);
        }

        return userOutput;
    }
}
