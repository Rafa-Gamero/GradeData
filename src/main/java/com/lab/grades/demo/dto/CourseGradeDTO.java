package com.lab.grades.demo.dto;

import com.lab.grades.demo.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseGradeDTO {
    private String courseName;
    private List<Grade> grades;


}