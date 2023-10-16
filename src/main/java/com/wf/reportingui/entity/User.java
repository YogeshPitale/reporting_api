package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("UserCredentials")
public class User {
    @Id
    private String id;
    private String email;
    private String username;
    private String password;
    private String role;
}
