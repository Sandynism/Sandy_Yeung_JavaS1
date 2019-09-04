package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<ProcessingFee> processingFeesList = processingFeeDao.getAllProcessingFees();
        for(ProcessingFee pf: processingFeesList) {
            processingFeeDao.deleteProcessingFee(pf.getProductType());
        }
    }

    @Test
    public void getAllProcessingFees() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("consoles");
        processingFee.setFee(new BigDecimal("14.99"));

        processingFeeDao.addProcessingFee(processingFee);

        processingFee = new ProcessingFee();
        processingFee.setProductType("games");
        processingFee.setFee(new BigDecimal("1.49"));

        processingFeeDao.addProcessingFee(processingFee);

        List<ProcessingFee> processingFeesList = processingFeeDao.getAllProcessingFees();
        assertEquals(processingFeesList.size(), 2);
    }

    @Test
    public void addGetDeleteProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("consoles");
        processingFee.setFee(new BigDecimal("14.99"));

        processingFeeDao.addProcessingFee(processingFee);

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertEquals(processingFee, processingFee1);

        processingFeeDao.deleteProcessingFee(processingFee.getProductType());
        processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertNull(processingFee1);
    }

    @Test
    public void updateProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("consoles");
        processingFee.setFee(new BigDecimal("14.99"));

        processingFeeDao.addProcessingFee(processingFee);

        processingFee.setFee(new BigDecimal("14.49"));

        processingFeeDao.updateProcessingFee(processingFee);
        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());
        assertEquals(processingFee, processingFee1);
    }
}

//    product_type varchar(20) not null,
//    fee decimal (4,2)