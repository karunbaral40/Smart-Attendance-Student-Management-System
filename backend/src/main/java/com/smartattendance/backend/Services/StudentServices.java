package com.smartattendance.backend.Services;

import com.smartattendance.backend.Dto.StudentResponseDto;
import com.smartattendance.backend.Entity.Student;
import com.smartattendance.backend.Repositery.StudentRepo;
import com.smartattendance.backend.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentServices {
    private final StudentMapper studentMapper;
    private final StudentRepo studentRepository;

    public StudentServices(StudentMapper studentMapper, StudentRepo studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto getStudentById(Integer id) {

        Optional<Student> studentOptional =
                studentRepository.findById(id);

        if (studentOptional.isPresent()) {

            Student student = studentOptional.get();

            return studentMapper.toDto(student);
        }

        return null;
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public StudentResponseDto createStudent(StudentResponseDto studentResponseDto) {
        Student student = studentMapper.toEntity(studentResponseDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }

    public StudentResponseDto updateStudent(Integer id, StudentResponseDto studentResponseDto) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(studentResponseDto.getName());
            existingStudent.setEmail(studentResponseDto.getEmail());
            existingStudent.setPhoneNumber(studentResponseDto.getPhoneNumber());
            existingStudent.setAddress(studentResponseDto.getAddress());
            Student updatedStudent = studentRepository.save(existingStudent);
            return studentMapper.toDto(updatedStudent);
        }
        return null;
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
