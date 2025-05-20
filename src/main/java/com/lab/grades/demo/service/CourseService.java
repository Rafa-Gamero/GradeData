package com.lab.grades.demo.service;

import com.lab.grades.demo.dto.CourseGrade;
import com.lab.grades.demo.model.Course;
import com.lab.grades.demo.model.Grade;
import com.lab.grades.demo.repository.CourseRepository;
import com.lab.grades.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public Optional<Course> getCourseByCode(String courseCode) {
        return courseRepository.findById(courseCode);
    }

    public List<CourseGrade> getGradesByCourseCode(String courseCode) {
        // Usa el método actualizado de GradeRepository
        List<Grade> grades = gradeRepository.findByCourseCourseCode(courseCode);
        // o si usaste la opción 2: List<Grade> grades = gradeRepository.findByCourseCode(courseCode);

        return grades.stream()
                .map(grade -> new CourseGrade(
                        grade.getCourse().getCourseCode(),
                        grade.getCourse().getCourseName(),
                        grade.getStudentId(),
                        grade.getGrade()
                ))
                .collect(Collectors.toList());
    }
}