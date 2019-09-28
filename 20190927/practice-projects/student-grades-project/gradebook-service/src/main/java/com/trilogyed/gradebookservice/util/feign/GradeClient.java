package com.trilogyed.gradebookservice.util.feign;

import com.trilogyed.gradebookservice.model.Grade;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "student-service")
public interface GradeClient {

    @GetMapping(value = "/grades/{id}")
    Grade getGrade(@PathVariable int id);

    @PostMapping(value = "/grades")
    Grade addGrade(@RequestBody Grade grade);

    @GetMapping(value = "/grades")
    List<Grade> getAllGrades();

    @PutMapping(value = "/grades/{id}")
    void updateGrade(@PathVariable int id, @RequestBody Grade grade);

    @DeleteMapping(value = "/grades/{id}")
    void deleteGrade(@PathVariable int id);

    @GetMapping(value="/grades/name/{studentId}")
    List<Grade> getAllGradesByStudentId(@PathVariable int studentId);
}
