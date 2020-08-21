package org.brogrammers.todoapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    TodoMockedData todoMockedData = TodoMockedData.getInstance();

    @GetMapping("/todo")
    public ResponseEntity<List<Todo>> index(){
        return new ResponseEntity(todoMockedData.fetchTodos(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> show(@PathVariable String id){
        return new ResponseEntity(todoMockedData.getTodoById(id), HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> create(@RequestBody Map<String, String> body){
        String id = body.get("id");
        String name = body.get("name");
        boolean isComplete = Boolean.getBoolean(body.get("complete"));
        return new ResponseEntity(todoMockedData.addTodo(id, name, isComplete), HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> editTodo(@PathVariable String id, @RequestBody Map<String, String> body){
        String name = body.get("name");
        boolean isComplete = Boolean.getBoolean(body.get("complete"));
        return new ResponseEntity(todoMockedData.updateTodo(id, name, isComplete), HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Todo> delete(@PathVariable String id){
        return new ResponseEntity(todoMockedData.deleteTodo(id), HttpStatus.OK);
    }
}
