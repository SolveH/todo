package org.brogrammers.todoapi.service;

import org.brogrammers.todoapi.exception.TodoNotFoundException;
import org.brogrammers.todoapi.model.Todo;

import java.util.List;

//The functions throw an IllegalArgumentException UUID is given incorrect string.
public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(String id) throws TodoNotFoundException, IllegalArgumentException;
    Todo updateTodo(String id, String newName, Boolean newComplete) throws TodoNotFoundException, IllegalArgumentException;
    void deleteTodo(String id) throws TodoNotFoundException, IllegalArgumentException;
    Todo addNewTodo(String name, boolean complete);
}
