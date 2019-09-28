package com.trilogyed.gradebookservice.service;

import com.trilogyed.gradebookservice.model.Grade;
import com.trilogyed.gradebookservice.model.Gradebook;
import com.trilogyed.gradebookservice.util.feign.GradeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLayer {
    char letterGrade;
    BigDecimal average;

    GradeClient gradeClient;

    @Autowired
    public ServiceLayer(GradeClient gradeClient) {
        this.gradeClient = gradeClient;
    }

    public Gradebook addGrade(Gradebook gb) {
        Grade grade = new Grade();
        grade.setId(gb.getId());
        grade.setStudentId(gb.getStudentId());
        grade.setAssignmentId(gb.getAssignmentId());
        grade.setPercentGrade(gb.getPercentGrade());

        gb.setId(grade.getId());
        gb.setStudentId(grade.getStudentId());
        gb.setAssignmentId(grade.getAssignmentId());
        gb.setPercentGrade(grade.getPercentGrade());

        return gb;
    }

    public List<Gradebook> getAllGrades() {
        List<Grade> grades = gradeClient.getAllGrades();
        List<Gradebook> allGradebooks = new ArrayList<>();

        grades.stream().forEach(g -> allGradebooks.add(buildGradebook(g.getId(), gradeClient)));
        return allGradebooks;
    }


    private Gradebook buildGradebook(int id, GradeClient gradeClient) {
        Integer percentGrade = gradeClient.getGrade(id).getPercentGrade();

        if (percentGrade >= 90) {
            letterGrade = 'A';
        } else if (percentGrade >= 80 && percentGrade < 90) {
            letterGrade = 'B';
        } else if (percentGrade >= 70 && percentGrade < 80) {
            letterGrade = 'C';
        } else if (percentGrade >= 60 && percentGrade < 70) {
            letterGrade = 'D';
        } else if (percentGrade < 60) {
            letterGrade = 'F';
        }

        List<Grade> gradesList = gradeClient.getAllGrades();

        List<Grade> studentsGrades = gradesList.stream().filter(g -> g.getStudentId() == gradeClient.getGrade(id).getStudentId()).collect(Collectors.toList());

        Integer gradesTotal = 0;
        BigDecimal total = new BigDecimal(gradesTotal);
        BigDecimal size = new BigDecimal(gradesList.size());

        for (Grade g : studentsGrades) {
            gradesTotal = gradesTotal + g.getPercentGrade();
        }

        average = total.divide(size);

        Gradebook gb = new Gradebook();
        gb.setId(gradeClient.getGrade(id).getId());
        gb.setStudentId(gradeClient.getGrade(id).getStudentId());
        gb.setAssignmentId(gradeClient.getGrade(id).getAssignmentId());
        gb.setPercentGrade(percentGrade);
        gb.setLetterGrade(letterGrade);
        gb.setAverage(average);

        return gb;
    }
}
