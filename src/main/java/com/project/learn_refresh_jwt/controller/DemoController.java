package com.project.learn_refresh_jwt.controller;

import com.project.learn_refresh_jwt.model.Student;
import com.project.learn_refresh_jwt.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final StudentService studentService;

    @Autowired
    public DemoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello from secured url");
    }

    @GetMapping("/admin_only")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin only url");
    }

    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student).toString());
    }
}
