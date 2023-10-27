package com.wf.reportingui.controller;

import com.wf.reportingui.dto.ReportDTO;
import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.MigrateReport;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.entity.ShareAnalysis;
import com.wf.reportingui.entity.SubmitQuery;
import com.wf.reportingui.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/addShareAnalysis")
    public ResponseEntity<Report> addShareAnalysis(@RequestParam String reportId, @RequestBody ShareAnalysis shareAnalysis) {
        return ResponseEntity.ok(reportService.addShareAnalysis(reportId, shareAnalysis));
    }

    @CrossOrigin
    @GetMapping("/getShareAnalysis")
    public ResponseEntity<ShareAnalysis> getShareAnalysis(@RequestParam String reportId) {
        return ResponseEntity.ok(reportService.getShareAnalysisByReportId(reportId));
    }

    @CrossOrigin
    @PutMapping("/{reportId}/approve")
    public ResponseEntity<Report> approveAnalysis(@PathVariable String reportId) {
        return ResponseEntity.ok(reportService.approveAnalysis(reportId));
    }

    @CrossOrigin
    @PutMapping("/{reportId}/reject")
    public ResponseEntity<Report> rejectAnalysis(@PathVariable String reportId) {
        return ResponseEntity.ok(reportService.rejectAnalysis(reportId));
    }

    @CrossOrigin
    @PostMapping("/submitQuery/{reportId}")
    public ResponseEntity<Report> submitQuery(@PathVariable String reportId, @RequestBody SubmitQuery query) {
        return new ResponseEntity<>(reportService.submitQuery(reportId, query), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getReports")
    public ResponseEntity<List<ReportDTO>> getReports(@RequestParam String userId) {
        return reportService.getReportsByUserId(userId)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @CrossOrigin
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
