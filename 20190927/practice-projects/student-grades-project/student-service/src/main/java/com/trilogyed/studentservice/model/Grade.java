package com.trilogyed.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "assignment_id")
    private Integer assignmentId;
    @Column(name = "percent_grade")
    private Integer percentGrade;

    public Grade() {
    }
    public Grade(Integer studentId, Integer assignmentId, Integer percentGrade) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.percentGrade = percentGrade;
    }

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

