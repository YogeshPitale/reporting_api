package com.wf.reportingui.dto;

import lombok.Data;

@Data
public class ReportDetailsDTO {
    private String id;
    private String reportName;
    private String source;
    private String target;
    private String url;
    public ReportDetailsDTO(String id, String reportName, String source, String target, String url) {
        this.id = id;
        this.reportName = reportName;
        this.source = source;
        this.target = target;
        this.url = url;
    }
}
