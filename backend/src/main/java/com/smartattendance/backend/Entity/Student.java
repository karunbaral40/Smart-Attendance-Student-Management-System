package com.smartattendance.backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,unique = true)
    @Email(message = "Email should be valid")
    private String email;
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;
    @Column(length = 255)
    private String address;
}
