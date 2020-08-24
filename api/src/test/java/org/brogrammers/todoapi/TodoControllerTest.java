package org.brogrammers.todoapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    TodoController controller;

    @Autowired
    TodoApiApplication wac;

    @Autowired
    MockMvc mvc;

    @Test // GET
    void whenGetTodos_thenReturnHTTPStatusOK() throws Exception {
        mvc.perform(get("/todo"))
                .andExpect(status().isOk());
        mvc.perform(get("/todo/1"))
                .andExpect(status().isOk());
    }

    @Test // CREATE
    void whenCreateTodo_thenReturnTodoAndHTTPStatusCreated() throws Exception {
        // make
        Todo todo = new Todo("45", "This is a todo", false);
        // put
        mvc.perform(post("/todo", todo))
                .andExpect(status().isCreated());
    }

    @Test // PUT
    void whenUpdateTodo_ThenReturnHTTPStatusOk() throws Exception {
        Todo todo = new Todo("1", "The todo is updated", false);
        mvc.perform(put("/todo/1", todo))
            .andExpect(status().isOk());
    }


    @Test // DEL
    void whenDeleteTodo_thenReturnHTTPStatusOk() throws Exception {
        mvc.perform(delete("/todo/1"))
            .andExpect(status().isOk());
    }

}
