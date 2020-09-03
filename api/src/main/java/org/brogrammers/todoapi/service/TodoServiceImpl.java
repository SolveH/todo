package org.brogrammers.todoapi.service;

import org.brogrammers.todoapi.exception.TodoNotFoundException;
import org.brogrammers.todoapi.model.Todo;
import org.brogrammers.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Todo getTodoById(String id) throws TodoNotFoundException, IllegalArgumentException {
        UUID uuid = UUID.fromString(id);
        return todoRepository.findById(uuid).orElseThrow(() -> new TodoNotFoundException("Could not find todo with ID: " + id));
    }

    @Override
    public Todo updateTodo(String id, String newName, Boolean newComplete) throws TodoNotFoundException, IllegalArgumentException {
        Todo todoToUpdate = getTodoById(id);
        todoToUpdate.setName(newName);
        todoToUpdate.setComplete(newComplete);
        return todoRepository.save(todoToUpdate);
    }

    @Override
    public void deleteTodo(String id) throws TodoNotFoundException, IllegalArgumentException {
        UUID uuid = UUID.fromString(id);
        if(todoRepository.existsById(uuid)){
            todoRepository.deleteById(uuid);
        }else{
            throw new TodoNotFoundException("Could not find todo with ID: " + id);
        }

    }

    @Override
    public Todo addNewTodo(String name, boolean complete) {
        Todo todo = new Todo(name, complete);
        return todoRepository.save(todo);
    }
}
