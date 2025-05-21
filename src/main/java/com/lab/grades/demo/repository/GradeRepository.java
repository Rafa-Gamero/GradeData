package com.lab.grades.demo.repository;

import com.lab.grades.demo.model.Course;
import com.lab.grades.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByCourse_CourseCode(String courseCode);
    List<Grade> findByCourse(Course course);

}