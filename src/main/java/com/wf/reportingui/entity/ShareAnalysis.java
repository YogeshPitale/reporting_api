package com.wf.reportingui.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ShareAnalysis {
    private String tShirtSize;
    private int timelines;
    private double cost;
}
