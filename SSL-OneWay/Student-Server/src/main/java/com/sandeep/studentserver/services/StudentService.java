package com.sandeep.studentserver.services;

import com.sandeep.studentserver.dtos.CreateStudentDto;
import com.sandeep.studentserver.entities.Student;
import com.sandeep.studentserver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // GET - List<Student>
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET - Student by ID
    public Student getStudentById(Integer student_id) {
        return studentRepository.findById(student_id).orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    // POST - Create Student
    public Student createStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setStudent_name(createStudentDto.getStudent_name());
        student.setStudent_age(createStudentDto.getStudent_age());
        student.setStudent_grade(createStudentDto.getStudent_grade());

        Student save = studentRepository.save(student);
        return save;
    }

    // UPDATE - Student by ID
    public Student updateStudent(Integer student_id, CreateStudentDto createStudentDto) {
        Student found_student = studentRepository.findById(student_id).orElseThrow(() -> new RuntimeException("Student Not Found"));
        found_student.setStudent_name(createStudentDto.getStudent_name());
        found_student.setStudent_age(createStudentDto.getStudent_age());
        found_student.setStudent_grade(createStudentDto.getStudent_grade());

        Student save = studentRepository.save(found_student);
        return save;
    }

    // DELETE - Student by ID
    public String deleteStudent(Integer student_id) {
        Student found_student = studentRepository.findById(student_id).orElseThrow(() -> new RuntimeException("Student Not Found"));
        studentRepository.delete(found_student);
        return "Deleted!";
    }
}
