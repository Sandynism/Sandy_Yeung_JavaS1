package com.trilogyed.gradebookservice.controller;

import com.trilogyed.gradebookservice.model.Gradebook;
import com.trilogyed.gradebookservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradebookController {

    @Autowired
    ServiceLayer sl;

    @PostMapping(value="/gradebooks")
    public Gradebook addGrade(@RequestBody Gradebook gb) {
        return sl.addGrade(gb);
    }

    @GetMapping(value="/gradebooks")
    public List<Gradebook> getAllGrades() {
        return sl.getAllGrades();
    }

}
