package com.trilogyed.studentservice.controller;

import com.trilogyed.studentservice.model.Grade;
import com.trilogyed.studentservice.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    public GradeRepository getRepository() {
        return gradeRepository;
    }

    public void setRepository(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping(value = "/grades/{id}")
    public Grade getGrade(@PathVariable int id) {
        return gradeRepository.getOne(id);
    }

    @PostMapping(value = "/grades")
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @GetMapping(value = "/grades")
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @PutMapping(value = "/grades/{id}")
    public void updateGrade(@PathVariable int id, @RequestBody Grade grade) {
        gradeRepository.save(grade);
    }

    @DeleteMapping(value = "/grades/{id}")
    public void deleteGrade(@PathVariable int id) {
        gradeRepository.deleteById(id);
    }

    @GetMapping(value = "/grades/name/{studentId}")
    List<Grade> getAllGradesByStudentId(@PathVariable int studentId) {
        return gradeRepository.getAllGradesByStudentId(studentId);
    }
}
