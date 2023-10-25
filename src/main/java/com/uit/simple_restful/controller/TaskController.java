package com.uit.simple_restful.controller;

import com.uit.simple_restful.dto.TaskDto;
import com.uit.simple_restful.dto.TaskResponseDto;
import com.uit.simple_restful.dto.UpdateTaskDto;
import com.uit.simple_restful.helper.ResponseHandler;
import com.uit.simple_restful.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
            return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST,errorMessage);
        }
        TaskResponseDto responseDto= taskService.createNewTask( dto);
    
        return ResponseHandler.getResponse(responseDto, HttpStatus.CREATED);

    }
    @GetMapping("/tasks")
    public ResponseEntity<Object> getAllTask(){
        List<TaskResponseDto> listTaskResponse= taskService.getAllTasks();
            return ResponseHandler.getResponse(listTaskResponse, HttpStatus.OK);

    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable("id")  String id){
        TaskResponseDto responseDto= taskService.getTaskById(id);
        
        if(responseDto!=null){
            return ResponseHandler.getResponse(responseDto, HttpStatus.OK);
        }
        String errorMessage = "ID not existed";
        return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST, errorMessage);

    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTaskById(@PathVariable("id") String id, @RequestBody UpdateTaskDto dto, BindingResult result){
        if (result.hasErrors()) {
            String errorMessage = "Title and description are required";
            return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST, errorMessage);
        }
        TaskResponseDto taskResponseDto= taskService.updateTaskById(id,dto);
        if(taskResponseDto!=null)
            return ResponseHandler.getResponse(taskResponseDto, HttpStatus.OK);
        String errorMessage = "ID not existed";
        return ResponseHandler.getResponse(HttpStatus.OK,errorMessage);
       
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTaskById(@PathVariable("id") String id){
        String message=taskService.deleteTaskById(id);
        return ResponseHandler.getResponse(message, HttpStatus.OK);

    }
    }
    