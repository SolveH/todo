package org.brogrammers.todoapi.service;

import org.brogrammers.todoapi.model.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo updateTodo(Todo todo);
    Todo deleteTodo(UUID id);
    Todo addNewTodo(String name, boolean complete);
}
