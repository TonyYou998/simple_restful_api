package com.uit.simple_restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String role;
    private String password;
}
