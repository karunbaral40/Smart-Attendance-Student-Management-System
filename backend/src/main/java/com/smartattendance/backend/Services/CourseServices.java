package com.smartattendance.backend.Services;

import com.smartattendance.backend.Dto.CourseRequestDto;
import com.smartattendance.backend.Dto.CourseResponseDto;
import com.smartattendance.backend.Entity.Course;
import com.smartattendance.backend.Exception.ResourceNotFoundException;
import com.smartattendance.backend.Repositery.CourseRepo;
import com.smartattendance.backend.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {
    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    public CourseServices(CourseRepo courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    public CourseResponseDto getCourseById(Integer id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return courseMapper.toDto(course);
    }

    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return courses.stream()
                .map(courseMapper::toDto)
                .toList();
    }

    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {
        Course course = courseMapper.toEntity(courseRequestDto);
        Course saved = courseRepo.save(course);
        return courseMapper.toDto(saved);
    }

    public CourseResponseDto updateCourse(Integer id, CourseRequestDto courseRequestDto) {
        Course existing = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));

        existing.setCode(courseRequestDto.getCode());
        existing.setName(courseRequestDto.getName());
        existing.setDescription(courseRequestDto.getDescription());
        existing.setDuration(courseRequestDto.getDuration());

        Course updated = courseRepo.save(existing);
        return courseMapper.toDto(updated);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        courseRepo.delete(course);
    }
}
