package com.putri.todoapp.service;

import com.putri.todoapp.entity.Todo;
import com.putri.todoapp.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
//    List<Todo> todoList = todoRepository.findAll();

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void showTodo(Boolean status) {

//        List<Todo> todoList = new ArrayList<>();
//        if (status == null) {
//            todoList = todoRepository.findAll();
//        } else {
//           todoList = todoRepository.findByStatus(status);
//        }

        List<Todo> todoList = status == null ? todoRepository.findAll() : todoRepository.findByStatus(status); // ternary operator

        System.out.println("\n TODO LIST");
        for (int number = 1; number <= todoList.size(); number++) {
            Todo todo = todoList.get(number - 1);
            String todoStatus = todo.getStatus() ? "Done" : "Need to do";
            System.out.println(number + ", " + todo.getDescription() + "(" + todoStatus + ")");

        }
    }

    @Override
    public void addTodo(String todoDescription) {
        Todo todo = new Todo();
        todo.setDescription(todoDescription);
        todo.setStatus(false);

        todoRepository.addOne(todo);
        System.out.println("Todo successfully added");
//        return null;
    }

    @Override
    public void deleteTodo(Integer id) {
        List<Todo> todoList = todoRepository.findAll();

        for (Todo todo : todoList) {
            Integer todoId = todo.getID();

            if (todoId != null && todoId.equals(id)) {
                todoRepository.deleteById(id);
                System.out.println("Todo successfully deleted");
                return;
            }
        }
        System.out.println("Todo with Todo with ID " + id + " not found.");
//        todoRepository.deleteById(id);
//        System.out.println("Todo successfully deleted");
    }

    @Override
    public void updateTodoStatus(Integer id, Boolean status) {
//        return null;
//        todoRepository.updateStatusById(id, status);
//        System.out.println("Todo successfully updated status");
        List<Todo> todoList = todoRepository.findAll();

        for (Todo todo : todoList) {
            Integer todoId = todo.getID();

            if (todoId != null && todoId.equals(id)) {
                todoRepository.updateStatusById(id, status);
                System.out.println("Todo successfully updated status");
                return;
            }
        }

        System.out.println("Todo with ID " + id + " not found.");
    }
}
