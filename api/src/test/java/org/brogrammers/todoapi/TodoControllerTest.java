package org.brogrammers.todoapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    void whenGetTodos_thenReturnHTTPStatusOK() throws Exception {
        mvc.perform(get("/todo"))
                .andExpect(status().isOk());
    }

}
