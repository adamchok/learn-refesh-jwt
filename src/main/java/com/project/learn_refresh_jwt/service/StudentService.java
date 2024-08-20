package com.project.learn_refresh_jwt.service;

import com.project.learn_refresh_jwt.model.Student;
import com.project.learn_refresh_jwt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Integer createStudent(Student student) {
        return studentRepository.save(student).getId();
    }
}
