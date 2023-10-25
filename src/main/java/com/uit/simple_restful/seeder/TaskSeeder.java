package com.uit.simple_restful.seeder;

import com.uit.simple_restful.entity.Task;
import com.uit.simple_restful.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TaskSeeder {
    private TaskRepository taskRepository;
    @EventListener
    public void seedTask(ContextRefreshedEvent e){

        List<Task> tasks= taskRepository.findAll();
        if(tasks.size()<1){
            tasks=new ArrayList<>();
           for(int i=0;i<100;i++){
               Task task=new Task();
               task.setTitle("demo"+String.valueOf(i));
               task.setDescription("this is a demo");
               tasks.add(task);
           }
           taskRepository.saveAll(tasks);
        }

    }
}
