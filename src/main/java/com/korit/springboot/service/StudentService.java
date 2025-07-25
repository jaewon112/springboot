package com.korit.springboot.service;

import com.korit.springboot.domain.entity.StudentEntity;
import com.korit.springboot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentEntity register(StudentEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    public boolean remove(Integer studentId) {
        studentRepository.deleteById(studentId);
        return true;
    }
}
