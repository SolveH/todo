package org.brogrammers.todoapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor
public class Todo {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid2")
    private UUID id;
    private String name;
    private boolean complete;

    public Todo(String name, boolean complete){
        this.name = name;
        this.complete = complete;
    }

    public Todo(UUID id, String name, boolean complete){
        this.id = id;
        this.name = name;
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
