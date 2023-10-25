package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("MigratedReports")
public class MigrateReport {
    @Id
    private String id;
    private String source;
    private String reportName;
    private String filePath;
    private String target;
    private ShareAnalysis shareAnalysis;
}
