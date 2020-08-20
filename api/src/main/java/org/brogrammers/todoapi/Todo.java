package org.brogrammers.todoapi;

public class Todo {
    private int id;
    private String name;
    private boolean complete;

    public Todo(){}

    public Todo(int id, String name, boolean complete){
        this.setId(id);
        this.setName(name);
        this.setComplete(complete);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
