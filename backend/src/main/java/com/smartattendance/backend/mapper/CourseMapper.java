package com.smartattendance.backend.mapper;

import com.smartattendance.backend.Dto.CourseRequestDto;
import com.smartattendance.backend.Dto.CourseResponseDto;
import com.smartattendance.backend.Entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDto dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setCode(dto.getCode());
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        return course;
    }

    public CourseResponseDto toDto(Course course) {
        CourseResponseDto dto = new CourseResponseDto();
        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setDuration(course.getDuration());
        return dto;
    }
}
