package com.lab.grades.demo.controller;

import com.lab.grades.demo.dto.CourseGradeDTO;
import com.lab.grades.demo.model.Course;
import com.lab.grades.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseCode}")
    public ResponseEntity<Course> getCourse(@PathVariable String courseCode) {
        Course course = courseService.getCourseByCode(courseCode);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/{courseCode}/grade")
    public ResponseEntity<CourseGradeDTO> getGradesForCourse(@PathVariable String courseCode) {
        CourseGradeDTO grades = courseService.getCourseGrade(courseCode);
        if (grades == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }
}