package com.smartattendance.backend.Controller;

import com.smartattendance.backend.Dto.StudentResponseDto;
import com.smartattendance.backend.Services.StudentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentServices.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentServices.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentResponseDto studentResponseDto) {
        StudentResponseDto createdStudent = studentServices.createStudent(studentResponseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody StudentResponseDto studentResponseDto) {
        return ResponseEntity.ok(studentServices.updateStudent(id, studentResponseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentServices.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
