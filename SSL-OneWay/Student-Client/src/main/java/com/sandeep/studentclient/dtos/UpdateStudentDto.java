package com.sandeep.studentclient.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentDto {
    private String student_name;
    private Integer student_age;
    private String student_grade;
}
