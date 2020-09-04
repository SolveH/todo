package org.brogrammers.todoapi;

import org.brogrammers.todoapi.controller.api.TodoController;
import org.brogrammers.todoapi.model.Todo;
import org.brogrammers.todoapi.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;
//https://www.springboottutorial.com/unit-testing-for-spring-boot-rest-services
@RunWith(SpringRunner.class)
@WebMvcTest(value = TodoController.class)
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Before
    public void init() throws Exception{
        UUID uuid = UUID.fromString("90411126-ede5-11ea-adc1-0242ac120002");
        Todo todo = new Todo(uuid, "Drink", false);
        String jsonExample = "{\"id\":\"90411126-ede5-11ea-adc1-0242ac120002\",\"name\":\"Drink\",\"complete\":true}";
        Mockito.when(todoService.getTodoById("90411126-ede5-11ea-adc1-0242ac120002")).thenReturn(todo);
    }


    @Test
    public void getTodoById() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo/90411126-ede5-11ea-adc1-0242ac120002").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{id:90411126-ede5-11ea-adc1-0242ac120002,name:Drink,complete:false}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}