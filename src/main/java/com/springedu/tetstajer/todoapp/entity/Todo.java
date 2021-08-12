package com.springedu.tetstajer.todoapp.entity;

import javax.persistence.*;

@Entity
@Table(name ="todo")

public class Todo {
    @Id
    @GeneratedValue//auotoincrement
    private  Long id;

    @Column(name = "value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
