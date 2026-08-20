package com.smartattendance.backend.Repositery;

import com.smartattendance.backend.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}

