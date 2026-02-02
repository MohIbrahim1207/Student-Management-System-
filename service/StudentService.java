package com.example.student.management.service;

import com.example.student.management.model.Student;
import com.example.student.management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // GET
    public List<Student> getAll() {
        return repo.findAll();
    }

    // POST
    public Student add(Student student) {
        return repo.save(student);
    }

    // PUT
    public Student update(Long id, Student student) {
        Student existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());

        return repo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
