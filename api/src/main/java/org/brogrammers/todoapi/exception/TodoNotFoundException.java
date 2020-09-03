package org.brogrammers.todoapi.exception;

import java.util.function.Supplier;

public class TodoNotFoundException extends Exception {
    public TodoNotFoundException(String message){
        super(message);
    }
}
