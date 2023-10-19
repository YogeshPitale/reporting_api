package com.wf.reportingui.service;


import com.wf.reportingui.entity.MigrateReport;
import com.wf.reportingui.entity.MigrateReportOutput;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.entity.User;
import com.wf.reportingui.repo.UserRepository;
import com.wf.reportingui.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Optional;

@Service
public class MigrateReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;

    public MigrateReportOutput migrateReport(String userId, MigrateReport migrateReport) throws FileNotFoundException {

        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isEmpty()) {
            throw new RuntimeException("User with given userId not found");
        } else {
            Report report = new Report();
            report.setUserId(existingUser.get().getId());
            report.setReportName(migrateReport.getReport());
            report.setStatus("Submitted for Analysis");
            report.setSource(migrateReport.getSource());
            report.setTarget(migrateReport.getTarget());
            report.setSubmittedDate(new Date().toString());
            Report saveReport = reportRepository.save(report);

            MigrateReportOutput migrateReportOutput = new MigrateReportOutput();
            migrateReportOutput.setMigratedReportId(saveReport.getId());
            migrateReportOutput.setSuccess(true);
            migrateReportOutput.setError(null);
            return migrateReportOutput;
        }
    }
}
