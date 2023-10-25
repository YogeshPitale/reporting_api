package com.wf.reportingui.controller;

import com.wf.reportingui.dto.ReportDTO;
import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/addReport/{userId}")
    public ResponseEntity<Report> addReport(@PathVariable String userId, @RequestBody Report report) {
        return ResponseEntity.ok(reportService.saveReport(userId, report));
    }

    @CrossOrigin
    @GetMapping("/getReports")
    public ResponseEntity<List<ReportDTO>> getReports(@RequestParam String userId) {
        return reportService.getReportsByUserId(userId)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/getAllReports")
    public ResponseEntity<List<ReportDTO>> getAllReportsByRole(@RequestParam String userId) {
        return ResponseEntity.ok(reportService.getAllReportsByRole(userId));
    }

    @CrossOrigin
    @GetMapping("/getReportDetails")
    public ResponseEntity<ReportDetailsDTO> getReportDetails(@RequestParam String reportId) {
        return reportService.getReportDetails(reportId)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
