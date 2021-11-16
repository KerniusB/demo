package com.example.demo.controller;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import com.example.demo.service.ActionService;
import com.example.demo.service.CashRegisterService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(value = CashRegisterController.class)
class CashRegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CashRegisterService cashRegisterService;

    @Test
    void getIt() throws Exception {
        List<CashRegister> cashRegisters = new ArrayList<>();
        cashRegisters.add(CashRegister.builder()
                .name("maxima")
                .build());

        cashRegisters.add(CashRegister.builder()
                .name("maxima")
                .build());

        when(cashRegisterService.findAll()).thenReturn(cashRegisters);

        RequestBuilder rb = MockMvcRequestBuilders.get("/cashRegister").accept(MediaType.TEXT_HTML);

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("cashRegister"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/cashRegister.jsp"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("cashRegisters"))
                .andReturn();
    }

    @Test
    void showAddPage() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/add-cashRegister");

        MvcResult result = mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("add-cashRegister"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/add-cashRegister.jsp"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("cashRegister"))
                .andExpect(MockMvcResultMatchers.model().attribute("cashRegister", hasProperty("name", emptyOrNullString())))
                .andReturn();
    }

    @Test
    void add() {
    }

    @Test
    void showUpdatePage() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() throws Exception {
        RequestBuilder rb = MockMvcRequestBuilders.get("/delete-cashRegister/1");

        mockMvc.perform(rb)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/cashRegister"))
                .andReturn();
        verify(cashRegisterService).deleteById(Mockito.anyLong());
    }
}