package com.wf.reportingui.service;

import com.wf.reportingui.dto.ReportDTO;
import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    public Optional<ReportDTO> getReportsByUserId(String userId) {
        Optional<Report> reports = reportRepository.findByUserId(userId);
        return reports
                .map(report -> new ReportDTO(report.getId(), report.getReportName()));

    }

    public Optional<ReportDetailsDTO> getReportDetails(String reportId) {
        Optional<Report> reportDetails = reportRepository.findById(reportId);
        return reportDetails.map(report -> new ReportDetailsDTO(report.getId(), report.getReportName(), report.getSource(), report.getTarget()));
    }

}
