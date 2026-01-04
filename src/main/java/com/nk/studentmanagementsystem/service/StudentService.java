package com.nk.studentmanagementsystem.service;

import com.nk.studentmanagementsystem.beans.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> listAll();
    public Optional<Student> findById(Long id);
    public Student create(Student student);
    public Student update(Long id, Student updated);
    public void delete(Long id);
    public Student findByEmail(String email);
}
