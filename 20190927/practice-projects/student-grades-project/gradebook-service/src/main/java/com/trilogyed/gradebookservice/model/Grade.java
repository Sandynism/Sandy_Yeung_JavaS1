package com.trilogyed.gradebookservice.model;


import java.util.Objects;

public class Grade {
    private Integer id;
    private Integer studentId;
    private Integer assignmentId;
    private Integer percentGrade;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return getId().equals(grade.getId()) &&
                getStudentId().equals(grade.getStudentId()) &&
                getAssignmentId().equals(grade.getAssignmentId()) &&
                getPercentGrade().equals(grade.getPercentGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentId(), getAssignmentId(), getPercentGrade());
    }


}
