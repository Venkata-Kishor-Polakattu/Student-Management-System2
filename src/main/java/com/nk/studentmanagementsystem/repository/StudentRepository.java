package com.nk.studentmanagementsystem.repository;

import com.nk.studentmanagementsystem.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
