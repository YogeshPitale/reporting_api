package com.wf.reportingui.service;

import com.wf.reportingui.dto.ReportDTO;
import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.entity.ShareAnalysis;
import com.wf.reportingui.entity.User;
import com.wf.reportingui.repo.UserRepository;
import com.wf.reportingui.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {
    final private static String WF_USER = "wf_user";
    final private static String PS_USER = "ps_user";
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;

    public Report saveReport(String userId, Report report, ShareAnalysis shareAnalysis) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent() && WF_USER.equalsIgnoreCase(existingUser.get().getRole())) {
            report.setUserId(existingUser.get().getId());
            report.setSubmittedBy(existingUser.get().getUsername());
            report.setShareAnalysis(shareAnalysis);
            if (report.getShareAnalysis() != null) {
                report.setStatus("Analysis Ready");
            } else {
                report.setStatus("Submitted For Analysis");
            }
            return reportRepository.save(report);
        } else {
            throw new RuntimeException("WF User not found");
        }
    }

    public Optional<List<ReportDTO>> getReportsByUserId(String userId) {
        List<Report> reports = reportRepository.findByUserId(userId);
        return Optional.of(reports.stream()
                .map(report -> new ReportDTO(
                        report.getId(),
                        report.getReportName(),
                        report.getStatus(),
                        report.getSubmittedDate(),
                        report.getSubmittedBy(),
                        report.getShareAnalysis()
                ))
                .collect(Collectors.toList()));
    }

    public List<ReportDTO> getAllReportsByRole(String userId) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent() && PS_USER.equalsIgnoreCase(existingUser.get().getRole())) {
            List<Report> reports = reportRepository.findAll();
            return reports.stream()
                    .map(report -> new ReportDTO(
                            report.getId(),
                            report.getReportName(),
                            report.getStatus(),
                            report.getSubmittedDate(),
                            report.getSubmittedBy(),
                            report.getShareAnalysis()
                    ))
                    .collect(Collectors.toList());

        } else if (existingUser.isPresent() && WF_USER.equalsIgnoreCase(existingUser.get().getRole())) {
            List<Report> userReports = reportRepository.findByUserId(existingUser.get().getId());
            return userReports.stream()
                    .map(report -> new ReportDTO(
                            report.getId(),
                            report.getReportName(),
                            report.getStatus(),
                            report.getSubmittedDate(),
                            report.getSubmittedBy(),
                            report.getShareAnalysis()
                    ))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public Optional<ReportDetailsDTO> getReportDetails(String reportId) {
        Optional<Report> reportDetails = reportRepository.findById(reportId);
        return reportDetails
                .map(report -> new ReportDetailsDTO(
                        report.getId(),
                        report.getReportName(),
                        report.getSource(),
                        report.getTarget()
                ));
    }

}
