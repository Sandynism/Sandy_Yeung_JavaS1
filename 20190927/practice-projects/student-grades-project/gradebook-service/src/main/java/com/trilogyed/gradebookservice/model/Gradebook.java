package com.trilogyed.gradebookservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Gradebook {
    private Integer id;
    private Integer studentId;
    private Integer assignmentId;
    private Integer percentGrade;
    private char letterGrade;
    private BigDecimal average;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getPercentGrade() {
        return percentGrade;
    }

    public void setPercentGrade(Integer percentGrade) {
        this.percentGrade = percentGrade;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gradebook gradebook = (Gradebook) o;
        return getLetterGrade() == gradebook.getLetterGrade() &&
                getId().equals(gradebook.getId()) &&
                getStudentId().equals(gradebook.getStudentId()) &&
                getAssignmentId().equals(gradebook.getAssignmentId()) &&
                getPercentGrade().equals(gradebook.getPercentGrade()) &&
                getAverage().equals(gradebook.getAverage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentId(), getAssignmentId(), getPercentGrade(), getLetterGrade(), getAverage());
    }





}
