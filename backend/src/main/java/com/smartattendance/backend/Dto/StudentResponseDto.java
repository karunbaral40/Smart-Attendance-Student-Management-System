package com.smartattendance.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

}
