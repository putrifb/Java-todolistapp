package com.putri.todoapp.repository;

import com.putri.todoapp.entity.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();
    List<Todo> findByStatus(Boolean status);
    Boolean addOne(Todo todo);
    Boolean deleteById(Integer id);
    Boolean updateStatusById(Integer id, Boolean status);
}
