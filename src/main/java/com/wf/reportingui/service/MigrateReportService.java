package com.wf.reportingui.service;


import com.wf.reportingui.entity.MigrateReport;
import com.wf.reportingui.entity.MigrateReportOutput;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.entity.User;
import com.wf.reportingui.repo.UserRepository;
import com.wf.reportingui.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class MigrateReportService {
    final private static String WF_USER = "wf_user";
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;

    public MigrateReportOutput migrateReport(String userId, MigrateReport migrateReport) {

        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent() && WF_USER.equalsIgnoreCase(existingUser.get().getRole())) {
            Report report = new Report();
            report.setUserId(existingUser.get().getId());
            report.setReportName(migrateReport.getReportName());
            report.setStatus("Submitted for Analysis");
            report.setSource(migrateReport.getSource());
            report.setTarget(migrateReport.getTarget());
            report.setSubmittedDate(Instant.now().toString());
            report.setSubmittedBy(existingUser.get().getUsername());
            report.setShareAnalysis(migrateReport.getShareAnalysis());
            Report saveReport = reportRepository.save(report);

            MigrateReportOutput migrateReportOutput = new MigrateReportOutput();
            migrateReportOutput.setMigratedReportId(saveReport.getId());
            migrateReportOutput.setSuccess(true);
            migrateReportOutput.setError(null);
            return migrateReportOutput;
        } else {
            throw new RuntimeException("User with given userId not found");
        }
    }
}
