package com.wf.reportingui.service;

import com.wf.reportingui.entity.MigrateReport;
import com.wf.reportingui.entity.MigrateReportOutput;
import com.wf.reportingui.repo.MigrateReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
@Service
public class MigrateReportService {
    public MigrateReportOutput migrateReport(MigrateReport migrateReport) throws FileNotFoundException {
        MigrateReportOutput migrateReportOutput = new MigrateReportOutput();
        migrateReportOutput.setMigratedReportId(migrateReport.getId());
        migrateReportOutput.setSuccess(true);
        migrateReportOutput.setError(null);
        return migrateReportOutput;
    }
}
