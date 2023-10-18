package com.wf.reportingui.controller;

import com.wf.reportingui.entity.MigrateReport;
import com.wf.reportingui.entity.MigrateReportOutput;
import com.wf.reportingui.repo.MigrateReportRepository;
import com.wf.reportingui.service.MigrateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class MigrateReportController {
    @Autowired
    private MigrateReportService migrateReportService;

    @PostMapping("/migrate")
    public ResponseEntity<MigrateReportOutput> migrateReport(@RequestBody MigrateReport migrateReport) throws FileNotFoundException {
        return new ResponseEntity<>(migrateReportService.migrateReport(migrateReport), HttpStatus.OK);
    }
}
