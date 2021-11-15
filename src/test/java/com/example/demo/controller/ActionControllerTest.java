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
//        Action action = Action.builder()
//                .inOut(100)
//                .date("2020-01-01")
//                .amount(123)
//                .build();
//
//        CashRegister cashRegister = CashRegister.builder()
//                .name("maxima")
//                .build();
//
//        when(actionService.add(Mockito.any(Action.class))).thenReturn(action);
//
//        RequestBuilder rb = MockMvcRequestBuilders
//                .post("/add-action")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("action", "maxima");
//
//        mockMvc.perform(rb)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/actions"))
//                .andReturn();
//
//        verify(actionService).add(Mockito.any(Action.class));
    }

    @Test
    void showUpdatePage() {
//        Action action = Action.builder()
//                .inOut(100)
//                .date("2020-01-01")
//                .amount(123)
//                .build();
//
//
//        CashRegister cashRegister = CashRegister.builder()
//                .name("maxima")
//                .build();
//
//
//        VeiksmasDTO veiksmasDTO = new VeiksmasDTO(1L, "insert", dateNow, 1L);
//        when(veiksmasService.findById(Mockito.anyLong())).thenReturn(veiksmas);
//        when(veiksmasService.mapVeiksmasToDTO(Mockito.any(Veiksmas.class))).thenReturn(veiksmasDTO);
//        RequestBuilder rb = MockMvcRequestBuilders.get("/update-veiksmas/1");
//
//        MvcResult result = mockMvc.perform(rb)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("add-veiksmas"))
//                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/add-veiksmas.jsp"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("veiksmas"))
//                .andExpect(MockMvcResultMatchers.model().attribute("veiksmas", hasProperty("veiksmas", Matchers.equalTo("insert"))))
//                .andExpect(MockMvcResultMatchers.model().attribute("veiksmas", hasProperty("data", Matchers.equalTo(dateNow))))
//                .andExpect(MockMvcResultMatchers.model().attribute("veiksmas", hasProperty("vartotojoId", Matchers.equalTo(1L))))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("vartotojai"))
//                .andReturn();
    }

    @Test
    void update() {
//        LocalDate dateNow = LocalDate.now();
//        Vartotojas v1 = new Vartotojas(1L, "Arijus", "8611111234", null);
//        Veiksmas veiksmas = new Veiksmas(1L, "insert", dateNow, v1);
//        VeiksmasDTO veiksmasDTO = new VeiksmasDTO(1L, "insert", dateNow, 1L);
//        when(veiksmasService.findById(Mockito.anyLong())).thenReturn(veiksmas);
//        when(veiksmasService.mapVeiksmasToDTO(Mockito.any(Veiksmas.class))).thenReturn(veiksmasDTO);
//        RequestBuilder rb = MockMvcRequestBuilders.get("/update-veiksmas/1");
//
//        MvcResult result = mockMvc.perform(rb)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("add-veiksmas"))
//                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/add-veiksmas.jsp"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("veiksmas"))
//                .andExpect(MockMvcResultMatchers.model().attribute("veiksmas", hasProperty("veiksmas", Matchers.equalTo("insert"))))
//                .andExpect(MockMvcResultMatchers.model().attribute("veiksmas", hasProperty("data", Matchers.equalTo(dateNow))))
//                .andExpect(MockMvcResultMatchers.model().attribute("veiksmas", hasProperty("vartotojoId", Matchers.equalTo(1L))))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("vartotojai"))
//                .andReturn();
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