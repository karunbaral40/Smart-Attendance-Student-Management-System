package com.smartattendance.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDto {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private Integer duration;
}
