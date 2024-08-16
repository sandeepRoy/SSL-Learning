package com.sandeep.studentserver.controllers;

import com.sandeep.studentserver.dtos.CreateStudentDto;
import com.sandeep.studentserver.entities.Student;
import com.sandeep.studentserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer student_id) {
        Student studentById = studentService.getStudentById(student_id);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentDto createStudentDto) {
        Student student = studentService.createStudent(createStudentDto);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer student_id, @RequestBody CreateStudentDto createStudentDto) {
        Student student = studentService.updateStudent(student_id, createStudentDto);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer student_id) {
        String response = studentService.deleteStudent(student_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
