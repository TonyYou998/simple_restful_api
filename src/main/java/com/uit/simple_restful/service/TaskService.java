package com.uit.simple_restful.service;


import com.uit.simple_restful.dto.TaskDto;
import com.uit.simple_restful.dto.TaskResponseDto;
import com.uit.simple_restful.dto.UpdateTaskDto;

import java.util.List;

public interface TaskService {
    TaskResponseDto createNewTask(TaskDto dto);

    List<TaskResponseDto> getAllTasks();

    TaskResponseDto getTaskById(String id);

    TaskResponseDto updateTaskById(String id, UpdateTaskDto dto);

    String deleteTaskById(String id);
}
