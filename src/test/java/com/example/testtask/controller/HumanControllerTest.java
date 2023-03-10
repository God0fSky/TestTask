package com.example.testtask.controller;


import com.example.testtask.dto.HumanDto;
import com.example.testtask.service.HumanService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by olegb on март, 2023
 */


@WebMvcTest(HumanController.class)
class HumanControllerTest {
    private static final int ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HumanService humanService;


    @Test
    void getHumanTest() throws Exception {
        HumanDto humanDto = new HumanDto(ID, "Test", "Test", LocalDate.of(ID, ID, ID), ID);
        Mockito.when(humanService.findById(ID)).thenReturn(humanDto);

        this.mockMvc.perform(get("/service/1"))
                .andDo(print())
                .andExpect(status().isOk());

        Mockito.verify(humanService).findById(ID);
    }

}
