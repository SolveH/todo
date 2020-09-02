package org.brogrammers.todoapi.controller.api;

import org.brogrammers.todoapi.model.Todo;
import org.brogrammers.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> index(){
        return new ResponseEntity<>(todoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> show(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return new ResponseEntity<>(todoRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        boolean isComplete = Boolean.getBoolean(body.get("complete"));
        Todo todo = new Todo(name, isComplete);
        return new ResponseEntity<>(todoRepository.save(todo), HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> editTodo(@PathVariable String id, @RequestBody Map<String, String> body){
        UUID uuid = UUID.fromString(id);
        Todo todoToUpdate = todoRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        String name = body.get("name");
        boolean isComplete = Boolean.parseBoolean(body.get("complete"));
        todoToUpdate.setName(name);
        todoToUpdate.setComplete(isComplete);
        return new ResponseEntity<>(todoRepository.save(todoToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Todo> delete(@PathVariable String id){
        try{
            UUID uuid = UUID.fromString(id);
            todoRepository.deleteById(uuid);
            return new ResponseEntity(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            System.out.println(e);
            System.out.println("The todo does not exist");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
