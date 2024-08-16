package com.sandeep.studentclient.services;

import com.sandeep.studentclient.dtos.UpdateStudentDto;
import com.sandeep.studentclient.endpoints.Endpoints;
import com.sandeep.studentclient.responses.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentClientService {
    @Autowired
    public WebClient studentClient;

    public StudentResponse getStudent(Integer student_id) {
        StudentResponse response = studentClient
                .get()
                .uri(Endpoints.GET_STUDENT_BY_ID, student_id)
                .retrieve()
                .bodyToMono(StudentResponse.class)
                .block();

        return response;
    }

    public StudentResponse updateStudent(Integer student_id, UpdateStudentDto updateStudentDto) {
        StudentResponse response = studentClient
                .put()
                .uri(Endpoints.UPDATE_STUDENT, student_id)
                .bodyValue(updateStudentDto)
                .retrieve()
                .bodyToMono(StudentResponse.class)
                .block();

        return response;
    }
}
