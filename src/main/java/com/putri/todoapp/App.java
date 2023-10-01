package com.putri.todoapp;

import com.putri.todoapp.repository.TodoRepository;
import com.putri.todoapp.repository.TodoRepositoryImpl;
import com.putri.todoapp.service.TodoService;
import com.putri.todoapp.service.TodoServiceImpl;
import com.putri.todoapp.view.TodoView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);

        TodoView todoView = new TodoView(todoService);
        todoView.showMenu();

    }
}
