package com.wf.reportingui.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "report")
@Data
public class Report {
    @Id
    private String id;

    @DBRef
    private User user;

    private String reportName;
    private String status;
    private String submittedDate;
    private String source;
    private String target;

}
