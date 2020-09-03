package org.brogrammers.todoapi.service;

import org.brogrammers.todoapi.exception.TodoNotFoundException;
import org.brogrammers.todoapi.model.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(String id) throws TodoNotFoundException, IllegalArgumentException;
    Todo updateTodo(String id, String newName, Boolean newComplete) throws TodoNotFoundException, IllegalArgumentException;
    void deleteTodo(String id) throws TodoNotFoundException, IllegalArgumentException;
    Todo addNewTodo(String name, boolean complete);
}
