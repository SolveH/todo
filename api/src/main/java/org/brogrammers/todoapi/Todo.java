package org.brogrammers.todoapi;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id @GeneratedValue (generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private boolean complete;

    public Todo() {

    }

    public Todo(String name, boolean complete){
        this.setName(name);
        this.setComplete(complete);
    }

    public Todo(String id, String name, boolean complete){
        this.setId(id);
        this.setName(name);
        this.setComplete(complete);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
