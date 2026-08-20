package com.smartattendance.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
