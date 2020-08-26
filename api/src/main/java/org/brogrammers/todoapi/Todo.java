package org.brogrammers.todoapi;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Todo {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private boolean complete;

    public Todo() {

    }

    public Todo(String name, boolean complete){
        this.setName(name);
        this.setComplete(complete);
    }

    public Todo(UUID id, String name, boolean complete){
        this.setId(id);
        this.setName(name);
        this.setComplete(complete);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", complete='" + complete + '\'' +
                '}';
    }


}
