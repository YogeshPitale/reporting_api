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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class MigrateReportController {
    @Autowired
    private MigrateReportService migrateReportService;

    @PostMapping("/migrate/{userId}")
    public ResponseEntity<MigrateReportOutput> migrateReport(@PathVariable String userId, @RequestBody MigrateReport migrateReport) throws FileNotFoundException {
        return new ResponseEntity<>(migrateReportService.migrateReport( userId, migrateReport), HttpStatus.OK);
    }
}
