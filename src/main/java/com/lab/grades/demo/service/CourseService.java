package com.lab.grades.demo.service;

import com.lab.grades.demo.dto.CourseGradeDTO;
import com.lab.grades.demo.model.Course;
import com.lab.grades.demo.model.Grade;
import com.lab.grades.demo.repository.CourseRepository;
import com.lab.grades.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;

    // Corregido: courseCode es String, no Long
    public Course getCourseByCode(String courseCode) {
        return courseRepository.findById(courseCode).orElse(null);
    }

    // Corregido: courseCode es String, no Long
    public CourseGradeDTO getCourseGrade(String courseCode) {
        Course course = getCourseByCode(courseCode);
        if (course == null){
            return null;
        }
        // Buscar calificaciones por el curso
        List<Grade> grades = gradeRepository.findByCourse(course);
        // O alternativamente, si quieres usar courseCode directamente:
        // List<Grade> grades = gradeRepository.findByCourse_CourseCode(courseCode);

        return new CourseGradeDTO(course.getCourseName(), grades);
    }
}