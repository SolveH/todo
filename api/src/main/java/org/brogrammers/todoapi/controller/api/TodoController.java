package org.brogrammers.todoapi.controller.api;

import org.brogrammers.todoapi.exception.TodoNotFoundException;
import org.brogrammers.todoapi.model.Todo;
import org.brogrammers.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> index(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> show(@PathVariable String id){
        try{
            Todo todo = todoService.getTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }catch(IllegalArgumentException | TodoNotFoundException e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        Boolean complete = Boolean.getBoolean(body.get("complete"));
        Todo todo = todoService.addTodo(name, complete);
        if(todo == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> editTodo(@PathVariable String id, @RequestBody Map<String, String> body){
        String newName = body.get("name");
        Boolean newComplete = Boolean.parseBoolean(body.get("complete"));
        try{
            Todo todo = todoService.updateTodo(id, newName, newComplete);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }catch(IllegalArgumentException | TodoNotFoundException e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Todo> delete(@PathVariable String id){
        try{
            todoService.deleteTodo(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (IllegalArgumentException | TodoNotFoundException e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
