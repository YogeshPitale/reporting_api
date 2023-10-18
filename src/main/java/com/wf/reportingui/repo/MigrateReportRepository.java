package com.wf.reportingui.repo;

import com.wf.reportingui.entity.MigrateReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MigrateReportRepository extends MongoRepository<MigrateReport, String> {
}
