package com.uit.simple_restful.dto;

import lombok.Data;

@Data
public class TaskResponseDto {
    private String id;
    private String title;
    private String description;
    private String completed;
}
