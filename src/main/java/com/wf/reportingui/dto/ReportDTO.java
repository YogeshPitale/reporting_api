package com.wf.reportingui.dto;

import lombok.Data;

@Data
public class ReportDTO {
    private String id;
    private String reportName;

    public ReportDTO(String id, String reportName) {
        this.id = id;
        this.reportName = reportName;
    }
}
