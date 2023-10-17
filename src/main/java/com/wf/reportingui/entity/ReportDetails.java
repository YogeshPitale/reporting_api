package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("Report")
public class ReportDetails {
    @Id
    private String reportId;
    private String userId;
    private String username;
    private String reportName;
    private String status;
    private String submittedDate;
}
