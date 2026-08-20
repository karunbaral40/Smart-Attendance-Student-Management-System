package com.smartattendance.backend.Services;

import com.smartattendance.backend.Repositery.CourseRepo;
import com.smartattendance.backend.mapper.CourseMapper;

public class CourseServices {
    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;
    public CourseServices(CourseRepo courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

}
