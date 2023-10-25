package com.uit.simple_restful.service;


import com.uit.simple_restful.dto.TaskDto;
import com.uit.simple_restful.dto.TaskResponseDto;
import com.uit.simple_restful.dto.UpdateTaskDto;
import com.uit.simple_restful.entity.Task;
import com.uit.simple_restful.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl  implements TaskService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private TaskRepository taskRepository;
    @Override
    public TaskResponseDto createNewTask(TaskDto dto) {
      
            Task newTask=new Task(dto.getTitle(),dto.getDescription());
            newTask= taskRepository.save(newTask);
            TaskResponseDto responseDto=new TaskResponseDto();
            responseDto.setId(newTask.getId().toString());
            responseDto.setTitle(newTask.getTitle());
            responseDto.setDescription(newTask.getDescription());
            responseDto.setCompleted(newTask.getCompleted().toString());
            return responseDto;

    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> listTask=taskRepository.findAll();
            List<TaskResponseDto> taskResponseDtoList=new ArrayList<>();

            listTask.forEach(task->{
                TaskResponseDto taskResponseDto=new TaskResponseDto();
                taskResponseDto.setId(task.getId().toString());
                taskResponseDto.setTitle(task.getTitle());
                taskResponseDto.setDescription(task.getDescription());
                taskResponseDto.setCompleted(task.getCompleted().toString());
                taskResponseDtoList.add(taskResponseDto);
            });
            return taskResponseDtoList;

    }

    @Override
    public TaskResponseDto getTaskById(String id) {
        try{
            Long taskId=Long.parseLong(id);
            Task task= taskRepository.findById(taskId).orElse(null);
            if(task!=null){

                TaskResponseDto taskResponseDto=new TaskResponseDto();
                taskResponseDto.setId(task.getId().toString());
                taskResponseDto.setTitle(task.getTitle());
                taskResponseDto.setDescription(task.getDescription());
                taskResponseDto.setCompleted(task.getCompleted().toString());
                return taskResponseDto;
            }
        }
        catch (NumberFormatException e){
            logger.info(e.getMessage());
            throw new NumberFormatException();
        }

        return null;
    }

    @Override
    public TaskResponseDto updateTaskById(String id, UpdateTaskDto dto) {
        try {
            Long taskId=Long.parseLong(id);
            Task task= taskRepository.findById(taskId).orElse(null);
            if(task==null)
                return null;
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setCompleted(Boolean.valueOf(dto.getCompleted()));
            task= taskRepository.save(task);
            if(task!=null){
                TaskResponseDto taskResponseDto=new TaskResponseDto();
                taskResponseDto.setId(task.getId().toString());
                taskResponseDto.setTitle(task.getTitle());
                taskResponseDto.setCompleted(task.getCompleted().toString());
                taskResponseDto.setDescription(task.getDescription());
                return taskResponseDto;
            }

        }
         catch (NumberFormatException e){
            logger.info(e.getMessage());
            throw new NumberFormatException();
        }
        return null;
    }

    @Override
    public String deleteTaskById(String id) {
        StringBuilder message = new StringBuilder();
        try {

            Task task=taskRepository.findById(Long.parseLong(id)).orElse(null);
            if(task!=null){
                taskRepository.delete(task);
                message.append("Task deleted successfully");
                return message.toString();
            }
            else{
                message.append("Task is not existed");
                return message.toString();
            }
        }
        catch (NumberFormatException e){
            logger.info(e.getMessage());
          throw new NumberFormatException();
        }


    }


}
