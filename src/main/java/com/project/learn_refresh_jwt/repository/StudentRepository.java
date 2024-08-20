package com.project.learn_refresh_jwt.repository;

import com.project.learn_refresh_jwt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
