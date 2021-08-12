package com.springedu.tetstajer.todoapp.dto;

public class TodoDTO {
    private String value;
    private Long id;

    public Long getId() {
        return id;
    }

    public TodoDTO(Long id,String value) {
        this.value = value;
        this.id = id;
    }

    public TodoDTO() {
    }

    public TodoDTO(String value) {
        this.value = value;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
