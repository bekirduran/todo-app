package com.springedu.tetstajer.todoapp.controller;


import com.springedu.tetstajer.todoapp.dto.TodoDTO;
import com.springedu.tetstajer.todoapp.entity.Todo;
import com.springedu.tetstajer.todoapp.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping(value = "read")
    public ResponseEntity<List<TodoDTO>> readAll() {
        List<Todo> todos = todoRepository.findAll();
        if (todos == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        List<TodoDTO> todoDTOList = new ArrayList<>();
        for (Todo todo : todos) {
            todoDTOList.add(new TodoDTO(todo.getId(),todo.getValue()));
        }
        return new ResponseEntity<>(todoDTOList, HttpStatus.OK);

    }

    @PostMapping(value = "create")
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO request) {

       Todo todo = new Todo();
        todo.setValue(request.getValue());
        todo = todoRepository.save(todo);

        return new ResponseEntity<>(new TodoDTO(todo.getId(), todo.getValue()),HttpStatus.OK);
    }


    @PutMapping(value = "update/{id}")
    public ResponseEntity<TodoDTO> update(@RequestBody TodoDTO request, @PathVariable Long id) {

   Optional<Todo> optionalTodo = todoRepository.findById(id);
   if(optionalTodo.isPresent()){
       Todo db = optionalTodo.get();
       db.setValue(request.getValue());
       db = todoRepository.save(db);
       return new ResponseEntity<>(new TodoDTO(db.getId(), db.getValue()),HttpStatus.OK);
   }

        return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
    }


    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id) {

        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if(optionalTodo.isPresent()){
            todoRepository.delete(optionalTodo.get());
            return new ResponseEntity<>(true,HttpStatus.OK);
        }

        return new ResponseEntity<>(false,HttpStatus.EXPECTATION_FAILED);
    }
}


