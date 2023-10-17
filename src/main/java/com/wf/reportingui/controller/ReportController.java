package com.wf.reportingui.controller;

import com.wf.reportingui.entity.ReportDetails;
import com.wf.reportingui.repo.ReportDetailsRepository;
import com.wf.reportingui.service.ReportDetailsService;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    private ReportDetailsRepository reportRepository;
    @Autowired
    private ReportDetailsService reportDetailsService;

    @PostMapping("/addReport")
    public ResponseEntity<ReportDetails> addReportDetails(@RequestBody ReportDetails reportDetails) {
        ReportDetails saveReportDetails = reportRepository.save(reportDetails);
        return new ResponseEntity<>(saveReportDetails, HttpStatus.OK);
    }

    @GetMapping("/reportDetails/{id}")
    public ResponseEntity<ReportDetails> getReportDetails(@PathVariable String id) {
        ReportDetails reportDetails = reportRepository.findByReportId(id);
        return new ResponseEntity<>(reportDetails, HttpStatus.OK);
    }

    @GetMapping("/report/{userid}")
    public ResponseEntity<ReportDetails> getReports(@PathVariable String userId) {
        ReportDetails getReportDetails = reportDetailsService.getReports(userId);
        return new ResponseEntity<>(getReportDetails, HttpStatus.OK);
    }
}
