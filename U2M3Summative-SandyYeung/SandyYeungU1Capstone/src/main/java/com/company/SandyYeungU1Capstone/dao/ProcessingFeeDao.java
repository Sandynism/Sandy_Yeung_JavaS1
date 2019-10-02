package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {
    List<ProcessingFee> getAllProcessingFees();

    ProcessingFee getProcessingFee(String productType);

    ProcessingFee addProcessingFee(ProcessingFee processingFee);

    void deleteProcessingFee(String productType);

    void updateProcessingFee(ProcessingFee processingFee);
}
