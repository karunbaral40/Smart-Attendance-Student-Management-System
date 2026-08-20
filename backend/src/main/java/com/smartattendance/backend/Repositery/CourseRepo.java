package com.smartattendance.backend.Repositery;

import com.smartattendance.backend.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
