package com.example.testtask.service;


import com.example.testtask.dto.HumanDto;
import com.example.testtask.mapper.HumanMapper;
import com.example.testtask.model.Human;
import com.example.testtask.repository.HumanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;


/**
 * Created by olegb on март, 2023
 */


@SpringBootTest
class HumanServiceTest {
    private static final int ID = 1;

    @MockBean
    private HumanRepository humanRepository;

    @Autowired
    private HumanService humanService;


    @Test
    void findByIdTest() {
        Human human = Human.builder()
                .id(ID)
                .name("Test")
                .firstName("First")
                .birthDate(LocalDate.of(ID, ID, ID))
                .build();
        Mockito.when(humanRepository.findById(ID)).thenReturn(Optional.ofNullable(human));

        HumanDto expected = humanService.findById(ID);

        Assertions.assertEquals(expected.getId(), human.getId());
        Assertions.assertEquals(expected.getName(), human.getName());
        Assertions.assertEquals(expected.getFirstName(), human.getFirstName());
        Assertions.assertEquals(expected.getBirthDate(), human.getBirthDate());
        Assertions.assertEquals(expected.getAge(), Period.between(human.getBirthDate(), LocalDate.now()).getYears());
    }

    @Test
    void createHumanTest() {
        HumanDto humanDto =
                new HumanDto(ID, "Test", "Test", LocalDate.of(ID, ID, ID), ID);

        Mockito.when(humanRepository.save(HumanMapper.INSTANCE.toHuman(humanDto))).thenReturn(
                Human.builder().id(ID).build()
        );

        HumanDto expected = humanService.createHuman(humanDto);

        Assertions.assertEquals(expected.getId(), humanDto.getId());
        Assertions.assertEquals(expected.getName(), humanDto.getName());
        Assertions.assertEquals(expected.getFirstName(), humanDto.getFirstName());
        Assertions.assertEquals(expected.getBirthDate(), humanDto.getBirthDate());
        Assertions.assertEquals(expected.getAge(), humanDto.getAge());

    }

}
