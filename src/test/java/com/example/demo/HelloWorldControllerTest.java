package com.example.demo;

import com.example.demo.helloWorld.web.HelloWorldController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("HelloWorld test case")
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test default HelloWorld")
    @Test
    public void testDefaultHelloWorld() throws Exception {
        this.mockMvc.perform(get("/getHelloWorld"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is("Hello, World!")));
    }
    @DisplayName("Test HelloWorld with query string parameter")
    @Test
    public void testHelloWorldWithParameter() throws Exception {
        String name = "Wavus";
        this.mockMvc.perform(get("/getHelloWorld?name=" + name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is("Hello, Wavus!")));
    }
}
