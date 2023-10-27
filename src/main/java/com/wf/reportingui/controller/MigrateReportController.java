package com.wf.reportingui.controller;

import com.wf.reportingui.dto.ReportDetailsDTO;
import com.wf.reportingui.entity.MigrateReport;
import com.wf.reportingui.entity.MigrateReportOutput;
import com.wf.reportingui.entity.Report;
import com.wf.reportingui.repo.MigrateReportRepository;
import com.wf.reportingui.service.MigrateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
public class MigrateReportController {
    @Autowired
    private MigrateReportService migrateReportService;

    @CrossOrigin
    @PostMapping("/migrate/{userId}")
    public ResponseEntity<MigrateReportOutput> migrateReport(@PathVariable String userId, @RequestPart("data") MigrateReport migrateReport,@RequestPart(value = "file", required = false) MultipartFile file) throws FileNotFoundException {
        return new ResponseEntity<>(migrateReportService.migrateReport(userId, migrateReport,file), HttpStatus.OK);
    }
}
