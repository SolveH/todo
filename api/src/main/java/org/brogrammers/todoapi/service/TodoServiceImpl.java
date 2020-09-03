package org.brogrammers.todoapi.service;

import org.brogrammers.todoapi.model.Todo;
import org.brogrammers.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return null;
    }

    @Override
    public Todo deleteTodo(UUID id) {
        return null;
    }

    @Override
    public Todo addNewTodo(String name, boolean complete) {
        return null;
    }
}
