package org.brogrammers.todoapi.controller.api;

import org.brogrammers.todoapi.model.Todo;
import org.brogrammers.todoapi.repository.TodoRepository;
import org.brogrammers.todoapi.service.TodoService;
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
    private TodoService todoService;

    @Autowired
    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> index(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> show(@PathVariable String id){
        UUID uuid;
        try{
            uuid = UUID.fromString(id);
        }catch(IllegalArgumentException e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Todo todo = todoService.getTodoById(uuid);
        if(todo != null){
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Map<String, String> body){
        Todo todo = todoService.addNewTodo(body.get("name"), Boolean.getBoolean(body.get("complete")));
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
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
