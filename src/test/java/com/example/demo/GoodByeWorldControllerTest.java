package com.example.demo;

import com.example.demo.helloWorld.web.GoodByeWorldController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("GoodByeWorld test case")
@WebMvcTest(GoodByeWorldController.class)
public class GoodByeWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test default GoodByeWorld")
    @Test
    public void testDefaultGoodByeWorld() throws Exception {
        this.mockMvc.perform(get("/getGoodByeWorld"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is("Good Bye World!")));
    }
    @DisplayName("Test GoodByeWorld with query string parameter")
    @Test
    public void testGoodByeWorldWithParameter() throws Exception {
        String name = "Wavus";
        this.mockMvc.perform(get("/getGoodByeWorld?name=" + name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is("Good Bye Wavus!")));
    }
}
