package com.wf.reportingui.repository;

import com.wf.reportingui.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    List<Report> findByUserId(String userId);

    Optional<Report> findById(String reportId);
}
