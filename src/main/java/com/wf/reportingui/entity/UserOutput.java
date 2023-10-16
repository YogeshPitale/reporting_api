package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserOutput {
    private String userId;
    private String username;
    private boolean success;
    private String role;
}
