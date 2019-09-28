package com.trilogyed.gradebookservice.service;

import com.trilogyed.gradebookservice.model.Grade;
import com.trilogyed.gradebookservice.util.feign.GradeClient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    GradeClient gradeClient;


    @Before
    public void setUp() throws Exception {
        setUpGradeClientMocks();
        serviceLayer = new ServiceLayer(gradeClient);
    }

    private void setUpGradeClientMocks() {
        gradeClient = mock(GradeClient.class);

        Grade grade = new Grade();

    }

    @Test
    public void addGrade() {
    }

    @Test
    public void getAllGrades() {
    }
}