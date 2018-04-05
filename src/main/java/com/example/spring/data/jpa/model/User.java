package com.example.spring.data.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
