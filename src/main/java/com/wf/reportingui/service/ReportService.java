package com.wf.reportingui.service;

import com.wf.reportingui.dto.ReportDTO;
import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.entity.User;
import com.wf.reportingui.repo.UserRepository;
import com.wf.reportingui.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;

    public Report saveReport(String userId, Report report) {
        User user = report.getUser();

        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            report.setUser(existingUser.get());
            return reportRepository.save(report);
        } else {
            throw new RuntimeException("User not found with Id: " + user.getId());
        }
    }

    public Optional<List<ReportDTO>> getReportsByUserId(String userId) {
        List<Report> reports = reportRepository.findByUserId(userId);
        return Optional.of(reports.stream()
                .map(report -> new ReportDTO(report.getId(), report.getReportName()))
                .collect(Collectors.toList()));

    }

    public Optional<ReportDetailsDTO> getReportDetails(String reportId) {
        Optional<Report> reportDetails = reportRepository.findById(reportId);
        return reportDetails.map(report -> new ReportDetailsDTO(report.getId(), report.getReportName(), report.getSource(), report.getTarget()));
    }

}
