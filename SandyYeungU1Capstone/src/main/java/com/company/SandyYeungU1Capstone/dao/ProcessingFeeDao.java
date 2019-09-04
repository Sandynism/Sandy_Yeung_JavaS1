package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.ProcessingFee;

public interface ProcessingFeeDao {
    ProcessingFee getProcessingFee(String productType);

    ProcessingFee addProcessingFee(ProcessingFeeDao processingFee);

    void deleteProcessingFee(String productType);

    void updateProcessingFee(ProcessingFeeDao processingFee);
}
