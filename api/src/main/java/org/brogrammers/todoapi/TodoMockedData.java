package org.brogrammers.todoapi;

import java.util.ArrayList;
import java.util.List;

public class TodoMockedData {

    private List<Todo> todos;

    private static TodoMockedData instance = null;
    public static TodoMockedData getInstance(){
        if(instance == null) instance = new TodoMockedData();
        return instance;
    }

    public TodoMockedData(){
        todos = new ArrayList<Todo>();
        todos.add(new Todo("1", "Clean your room", false));
        todos.add(new Todo("2", "Wash clothes", false));
        todos.add(new Todo("3", "Do your todos", false));
        todos.add(new Todo("4", "Fold your clothes", false));
    }

    public List<Todo> fetchTodos(){
        return todos;
    }

    public Todo getTodoById(String id){
        for(Todo t: todos){
            if(t.getId() == id) return t;
        }
        return null;
    }

    public Todo addTodo(String id, String name, boolean complete){
        Todo newTodo = new Todo(id, name, complete);
        todos.add(newTodo);
        return newTodo;
    }

    public Todo updateTodo(String id, String name, boolean complete){
        id = id.trim();
        for(Todo t: todos){
            String searchTodoId = t.getId().trim();
            if(searchTodoId.equals(id)){
                int index = todos.indexOf(t);
                t.setName(name);
                t.setComplete(complete);
                todos.set(index, t);
                return t;
            }
        }
        return null;
    }

    public boolean deleteTodo(String id){
        id = id.trim();
        int index = -1;
        for(Todo t: todos) {
            String newTodoId = t.getId().trim();
            if(newTodoId.equals(id)) {
                index = todos.indexOf(t);
                continue;
            }
        }
        if(index > -1){
            todos.remove(index);
        }
        return true;

    }
}
