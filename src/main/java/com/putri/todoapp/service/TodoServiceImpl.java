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
        Boolean isDeleted = todoRepository.deleteById(id);

        if (isDeleted) {
            System.out.println("Todo successfully deleted");
        } else {
            System.out.println("Todo with ID " + id + " not found.");
        }
    }

    @Override
    public void updateTodoStatus(Integer id, Boolean status) {

        Boolean isUpdated = todoRepository.updateStatusById(id, status);

        if (isUpdated) {
            System.out.println("Todo status updated successfully.");
        } else {
            System.out.println("Todo with ID " + id + " not found.");
        }
    }
}
