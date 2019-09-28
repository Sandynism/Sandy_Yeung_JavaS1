package com.trilogyed.studentservice.repository;

import com.trilogyed.studentservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Transactional
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    List<Grade> getAllGradesByStudentId(@PathVariable int studentId);
}
