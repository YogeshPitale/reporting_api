package com.wf.reportingui.dto;

import lombok.Data;

@Data
public class ReportDTO {
    private String id;
    private String reportName;
    private String status;
    private String submittedDate;

    public ReportDTO(String id, String reportName, String status, String submittedDate) {
        this.id = id;
        this.reportName = reportName;
        this.status = status;
        this.submittedDate = submittedDate;
    }
}
