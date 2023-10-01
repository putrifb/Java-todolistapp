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
        return null;
        //TODO by mputt
    }

    @Override
    public Boolean addOne(Todo todo) {
        return todolist.add(todo);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return todolist.remove(id);
    }

    @Override
    public Boolean updateStatusById(Integer id, Boolean status) {

        for (Todo todo : todolist) {
            if (todo.getID().equals(id)) {
               todo.setStatus(status);
               return true;
            }
        }
//        Todo todo = todolist.get(id);
//        if (todo != null) {
//            todo.setStatus(status);
//            return true;
//        }
        return false;
    }
}
