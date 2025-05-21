package com.lab.grades.demo.repository;

import com.lab.grades.demo.model.Course;
import com.lab.grades.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findByCourseCode(String courseCode);
}
