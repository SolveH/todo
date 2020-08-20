package org.brogrammers.todoapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    TodoMockedData todoMockedData = TodoMockedData.getInstance();

    @GetMapping("/todo")
    public List<Todo> index(){
        return todoMockedData.fetchTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo show(@PathVariable String id){
        return todoMockedData.getTodoById(id);
    }

    @PostMapping("/todo")
    public Todo create(@RequestBody Map<String, String> body){
        String id = body.get("id");
        String name = body.get("name");
        boolean isComplete = Boolean.getBoolean(body.get("complete"));
        return todoMockedData.addTodo(id, name, isComplete);
    }

    @PutMapping("/todo/{id}")
    public Todo editTodo(@PathVariable String id, @RequestBody Map<String, String> body){
        System.out.println(body);
        String name = body.get("name");
        boolean isComplete = Boolean.getBoolean(body.get("complete"));
        return todoMockedData.updateTodo(id, name, isComplete);
    }

    @DeleteMapping("/todo/{id}")
    public boolean delete(@PathVariable String id){
        return todoMockedData.deleteTodo(id);
    }
}
