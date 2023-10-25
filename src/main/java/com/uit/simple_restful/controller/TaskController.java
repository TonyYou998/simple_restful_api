package com.uit.simple_restful.controller;

import com.uit.simple_restful.dto.TaskDto;
import com.uit.simple_restful.dto.TaskResponseDto;
import com.uit.simple_restful.dto.UpdateTaskDto;
import com.uit.simple_restful.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @GetMapping("/demo")
    public Object demo(){
        return "This is a simple restful api";
    }
    @PostMapping("/tasks")
    public ResponseEntity<Object> createNewTask(@RequestBody @Valid TaskDto dto, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = "Title and description are required";
            return ResponseEntity.badRequest().body(errorMessage);
        }
        TaskResponseDto responseDto= taskService.createNewTask( dto);
        if(responseDto!=null)
            return ResponseEntity.ok(responseDto);
        return ResponseEntity.status(500).build();

    }
    @GetMapping("/tasks")
    public ResponseEntity<Object> getAllTask(){
        List<TaskResponseDto> listTaskResponse= taskService.getAllTasks();
        if(listTaskResponse!=null)
            return ResponseEntity.ok(listTaskResponse);
        return ResponseEntity.status(500).build();

    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable("id")  String id){
        TaskResponseDto responseDto= taskService.getTaskById(id);
        if(responseDto!=null){
            return ResponseEntity.ok(responseDto);
        }
        return ResponseEntity.badRequest().body("Task not existed");

    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTaskById(@PathVariable("id") String id, @RequestBody UpdateTaskDto dto, BindingResult result){
        if (result.hasErrors()) {
            String errorMessage = "Title and description are required";
            return ResponseEntity.badRequest().body(errorMessage);
        }
        TaskResponseDto taskResponseDto= taskService.updateTaskById(id,dto);
        if(taskResponseDto !=null)
            return ResponseEntity.ok(taskResponseDto);
        return ResponseEntity.status(500).build();
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") String id){
        String message=taskService.deleteTaskById(id);
        return ResponseEntity.ok(message);

    }
    }
    