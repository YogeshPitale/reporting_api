package com.wf.reportingui.controller;

import com.wf.reportingui.dto.ReportDTO;
import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/addReport")
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.saveReport(report));
    }

    @GetMapping("/getReports")
    public ResponseEntity<ReportDTO> getReports(@RequestParam String userId) {
        return reportService.getReportsByUserId(userId)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getReportDetails")
    public ResponseEntity<ReportDetailsDTO> getReportDetails(@RequestParam String reportId) {
        return reportService.getReportDetails(reportId)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
