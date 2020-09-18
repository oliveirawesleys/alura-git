package com.crud.api.crudexample.controller;

import com.crud.api.crudexample.model.Student;
import com.crud.api.crudexample.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping({"/students"})
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List findAll() {
        return studentRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student create(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Student student) {
        return studentRepository.findById(id)
                .map(record -> {
                    record.setName(student.getName());
                    record.setEmail(student.getEmail());
                    record.setPhone(student.getPhone());
                    Student updated = studentRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(record -> {
                    studentRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
