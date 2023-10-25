package com.uit.simple_restful.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Task extends BaseEntity {
    private  String title;
    private  String description;
    protected Boolean completed=false;
    public Task(String title,String description){
            this.title=title;
            this.description=description;
    }

}
