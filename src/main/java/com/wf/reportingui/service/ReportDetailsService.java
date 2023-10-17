package com.wf.reportingui.service;

import com.wf.reportingui.entity.ReportDetails;
import com.wf.reportingui.repo.ReportDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportDetailsService {

    @Autowired
    private ReportDetailsRepository reportRepository;

    public ReportDetails getReportDetails(String id) {
        ReportDetails reportDetails = reportRepository.findByReportId(id);
        return reportDetails;
    }

    public ReportDetails getReports(String userId) {
        ReportDetails reportDetails = reportRepository.findByUserId(userId);
        return reportDetails;
    }
}
