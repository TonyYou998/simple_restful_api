package com.uit.simple_restful.dto;

import lombok.Data;

@Data
public class UpdateTaskDto extends TaskDto{
    String completed;
}
