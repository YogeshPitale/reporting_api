package com.wf.reportingui.service;

import com.wf.reportingui.entity.User;
import com.wf.reportingui.entity.UserOutput;
import com.wf.reportingui.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserOutput validateCredentials(String username, String password) {
        User existingUser = userRepository.findByUsername(username,password);
        UserOutput userOutput = new UserOutput();

            if (existingUser != null) {
                userOutput.setSuccess(true);
                userOutput.setRole(existingUser.getRole());

            }
                else {
                    userOutput.setSuccess(false);
                    userOutput.setRole(null);
                }

        return userOutput;
    }
}
