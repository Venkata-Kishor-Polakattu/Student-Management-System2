package com.nk.studentmanagementsystem.service;

import com.nk.studentmanagementsystem.beans.Student;
import com.nk.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> listAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Student create(Student student) {
        // basic uniqueness check for email; let DB also enforce unique constraint
        /*repo.findByEmail(student.getEmail()).ifPresent(s -> {
            throw new IllegalArgumentException("Email already exists: " + student.getEmail());
        });*/
        return repo.save(student);
    }

    @Override
    public Student update(Long id, Student updated) {
        return repo.findById(id).map(existing -> {
            existing.setFirstName(updated.getFirstName());
            existing.setLastName(updated.getLastName());
            existing.setEmail(updated.getEmail());
            existing.setDateOfBirth(updated.getDateOfBirth());
            existing.setGrade(updated.getGrade());
            return repo.save(existing);
        }).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}