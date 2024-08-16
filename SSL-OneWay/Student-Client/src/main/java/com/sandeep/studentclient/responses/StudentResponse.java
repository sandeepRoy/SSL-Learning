package com.sandeep.studentclient.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String student_name;
    private Integer student_age;
    private String student_grade;
}
