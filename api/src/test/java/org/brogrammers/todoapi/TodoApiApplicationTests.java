package org.brogrammers.todoapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.brogrammers.todoapi.controller.api.TodoController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApiApplicationTests {
    @Autowired
    private TodoController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
