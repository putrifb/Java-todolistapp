package com.putri.todoapp.service;

import com.putri.todoapp.entity.Todo;

import java.util.List;

public interface TodoService {
    void showTodo(Boolean status);
    void addTodo(String todoDescription);
    void deleteTodo(Integer id);
    void updateTodoStatus(Integer id, Boolean status);
}
