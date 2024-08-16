package com.sandeep.studentclient.controllers;

import com.sandeep.studentclient.dtos.UpdateStudentDto;
import com.sandeep.studentclient.responses.StudentResponse;
import com.sandeep.studentclient.services.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class StudentClientController {

    @Autowired
    private StudentClientService studentClientService;

    @GetMapping("/get/{student_id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Integer student_id) {
        StudentResponse student_response = studentClientService.getStudent(student_id);
        return new ResponseEntity<>(student_response, HttpStatus.OK);
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Integer student_id, @RequestBody UpdateStudentDto updateStudentDto) {
        StudentResponse student_respone = studentClientService.updateStudent(student_id, updateStudentDto);
        return new ResponseEntity<>(student_respone, HttpStatus.OK);
    }
}
