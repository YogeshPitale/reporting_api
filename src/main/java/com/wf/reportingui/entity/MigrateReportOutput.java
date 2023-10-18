package com.wf.reportingui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MigrateReportOutput {
    private boolean success;
    private String migratedReportId;
    private String error;
}
