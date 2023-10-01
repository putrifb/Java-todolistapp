package com.putri.todoapp.repository;

import com.putri.todoapp.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryImpl implements TodoRepository{

    private List<Todo> todolist = new ArrayList<>();

    @Override
    public List<Todo> findAll() {
        return todolist;
    }

    @Override
    public List<Todo> findByStatus(Boolean status) {
        List<Todo> result = new ArrayList<>();
        for (Todo todo : todolist) {
            if (todo.getStatus() != null && todo.getStatus().equals(status)) {
                result.add(todo);
            }
        }
        return result;
        //TODO by mputt
    }

    @Override
    public Boolean addOne(Todo todo) {
        return todolist.add(todo);
    }

    @Override
    public Boolean deleteById(Integer id) {
        if ( id >= 1 && id < todolist.size()) {
            todolist.remove(id - 1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateStatusById(Integer id, Boolean status) {

        if (id >= 1 && id <= todolist.size()) {
            Todo todo = todolist.get(id - 1);
            todo.setStatus(status);
            return true;
        }
        return false;
    }
}
