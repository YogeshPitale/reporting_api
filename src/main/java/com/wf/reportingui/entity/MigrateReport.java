package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MigrateReport {
    @Id
    private String id;
    private String source;
    private String report;
    private String filePath;
    private String target;
}
