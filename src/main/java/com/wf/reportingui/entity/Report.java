package com.wf.reportingui.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "report")
@Data
public class Report {
    @Id
    private String id;

    private String userId;
    private String reportName;
    private String status;
    private String submittedDate;
    private String submittedBy;
    private String source;
    private String target;
    private String url;
    private ShareAnalysis shareAnalysis;

}
