package com.mockitotest.business;

import java.util.ArrayList;
import java.util.List;

import com.mockitotest.data.api.TodoService;

// TodoBusinessImpl is the SUT, or system under test
// TodoService is the Dependency
public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodoRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);

        for(String todo: todos) {
            if(todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;

    }

    public void deleteTodoNotRelatedToSpring(String user) {
        List<String> todos = todoService.retrieveTodos(user);

        for(String todo: todos) {
            if(!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }

    }
}
