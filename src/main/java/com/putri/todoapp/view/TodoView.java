package com.putri.todoapp.view;

import com.putri.todoapp.service.TodoService;
import com.putri.todoapp.util.InputUtil;

import java.util.Scanner;

public class TodoView {

    private final TodoService todoService;

    public TodoView(TodoService todoService) {
        this.todoService = todoService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. Show Todo List");
            System.out.println("2. Add a new Todo");
            System.out.println("3. Update a Todo Status");
            System.out.println("4. Delete a Todo");
            System.out.println("5. Quit app");

//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Choose menu (number only) : ");
//            String chosenMenu = scanner.nextLine();

            String chosenMenu = InputUtil.input("Choose menu (number only) : ");

//            if (chosenMenu.equals("1")) {
//                showTodo();
//            } else if (chosenMenu.equals("2")) {
//                addTodo();
//            } else if (chosenMenu.equals("3")) {
//                updateTodo();
//            } else if (chosenMenu.equals("4")) {
//                deleteTodo();
//            } else if (chosenMenu.equals("5")) {
//                break;
//            } else {
//                System.out.println("Input Not Valid");
//            }

            switch (chosenMenu) {
                case "1":
                    showTodo();
                    break;
                case "2":
                    addTodo();
                    break;
                case "3":
                    updateTodo();
                    break;
                case "4":
                    deleteTodo();
                    break;
                case "5":
                    return;  // Exit the loop and quit the app
                default:
                    System.out.println("Input Not Valid");
                    break;
            }
        }
    }
    private void showTodo() {

        System.out.println("\n Filter Option");
        System.out.println("1. Show all");
        System.out.println("2. Finished Todo");
        System.out.println("3. Unfinished Todo");

        String chosenFilterOption = InputUtil.input("Select filter : ");

        Boolean status;
        if (chosenFilterOption.equals("1")) {
            status = null;
        } else if (chosenFilterOption.equals("2")){
            status = true;
        } else if (chosenFilterOption.equals("3")) {
            status = false;
        } else {
            System.out.println("input not valid");
            return;
        }

        System.out.println("\n TODO LIST");
        todoService.showTodo(status);
    }
    private void addTodo() {
        System.out.println("ADD NEW TODO");

        String todoDescription = InputUtil.input("Input Todo : ");
        todoService.addTodo(todoDescription);
    }
    private void deleteTodo() {
        System.out.println("DELETE TODO");

        String todoIdString = InputUtil.input("Input todo ID to delete : ");
        if (todoIdString.isEmpty()) {
            System.out.println("Todo ID cannot be empty.");
            return;
        }

        try {
            int todoId = Integer.parseInt(todoIdString);
            todoService.deleteTodo(todoId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for todo ID. Please enter a valid integer.");
        }
    }
    private void updateTodo() {
        System.out.println("UPDATE TODO STATUS");

        String todoId = InputUtil.input("Input todo ID to Update : ");
        String todoStatus = InputUtil.input("Update todo status (true for finished or false for unfinished) : ");

        if (todoStatus.equalsIgnoreCase("true") || todoStatus.equalsIgnoreCase("false")) {
            todoService.updateTodoStatus(Integer.parseInt(todoId), Boolean.parseBoolean(todoStatus));
        } else {
            System.out.println("Invalid input for todo status. Please enter `true` or `false`.");
        }
    }
}
