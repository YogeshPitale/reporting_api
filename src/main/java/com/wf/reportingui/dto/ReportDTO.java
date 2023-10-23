package com.wf.reportingui.dto;

import lombok.Data;

@Data
public class ReportDTO {
    private String id;
    private String reportName;
    private String status;
    private String submittedDate;
    private String submittedBy;

    public ReportDTO(String id, String reportName, String status, String submittedDate, String submittedBy) {
        this.id = id;
        this.reportName = reportName;
        this.status = status;
        this.submittedDate = submittedDate;
        this.submittedBy = submittedBy;
    }
}
