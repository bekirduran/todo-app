package com.springedu.tetstajer.todoapp.repository;


import com.springedu.tetstajer.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
  //  @Query("select * from aaa")
  //  List<Todo> aaa();


}
