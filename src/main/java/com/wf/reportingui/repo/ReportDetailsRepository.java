package com.wf.reportingui.repo;

import com.wf.reportingui.entity.ReportDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportDetailsRepository extends MongoRepository<ReportDetails, String> {
    ReportDetails findByReportId(String id);

    ReportDetails findByUserId(String UserId);
}
