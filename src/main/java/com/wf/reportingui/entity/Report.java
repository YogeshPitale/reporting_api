package com.wf.reportingui.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "report")
@Data
public class Report {
    @Id
    private String id;

    @Indexed
    private String userId;
    private String reportName;
    private String source;
    private String target;

}
