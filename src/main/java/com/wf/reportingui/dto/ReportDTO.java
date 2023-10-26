package com.wf.reportingui.dto;

import com.wf.reportingui.entity.ShareAnalysis;
import lombok.Data;

@Data
public class ReportDTO {
    private String id;
    private String reportName;
    private String status;
    private String submittedDate;
    private String submittedBy;
    private ShareAnalysis shareAnalysis;

    public ReportDTO(String id, String reportName, String status, String submittedDate, String submittedBy, ShareAnalysis shareAnalysis) {
        this.id = id;
        this.reportName = reportName;
        this.status = status;
        this.submittedDate = submittedDate;
        this.submittedBy = submittedBy;
        this.shareAnalysis = shareAnalysis;
    }
}
