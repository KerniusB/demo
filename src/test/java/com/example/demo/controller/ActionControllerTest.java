package com.example.demo.controller;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import com.example.demo.service.ActionService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(value = ActionController.class)
class ActionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ActionService actionService;

    @Test
    void getIt() throws Exception {
        List<Action> actions = new ArrayList<>();
        actions.add(Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build());

        actions.add(Action.builder()
                .inOut(100)
                .date("1243-01-01")
                .amount(123)
                .build());

        when(actionService.findAll()).thenReturn(actions);

        RequestBuilder rb = MockMvcRequestBuilders.get("/action").accept(MediaType.TEXT_HTML);

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("action"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/action.jsp"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("actions"))
                .andReturn();
    }

    @Test
    void showAddPage() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/add-action");

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("add-action"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/add-action.jsp"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("action"))
                .andExpect(MockMvcResultMatchers.model().attribute("action", hasProperty("inOut", Matchers.equalTo(0L))))
                .andExpect(MockMvcResultMatchers.model().attribute("action", hasProperty("date", emptyOrNullString())))
                .andReturn();
    }

    @Test
    void add() throws Exception {
    }

    @Test
    void showUpdatePage() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/delete-action/1");

        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/action"))
                .andReturn();
        verify(actionService).deleteById(Mockito.anyLong());
    }
}