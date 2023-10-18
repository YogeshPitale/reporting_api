package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MigrateReportOutput {
    private String migratedReportId;
    private boolean success;
    private String error;
}
