package com.example.testtask.mapper;


import com.example.testtask.dto.HumanDto;
import com.example.testtask.model.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


/**
 * Created by olegb on март, 2023
 */


@SpringBootTest
class HumanMapperTest {

    private static final int ID = 1;


    @Test
    void toHumanTest() {
        HumanDto humanDto = new HumanDto(ID, "Test", "Test", LocalDate.now(), ID);

        Human human = HumanMapper.INSTANCE.toHuman(humanDto);

        Assertions.assertNotNull(human);
        Assertions.assertEquals(human.getId(), humanDto.getId());
        Assertions.assertEquals(human.getName(), humanDto.getName());
        Assertions.assertEquals(human.getFirstName(), humanDto.getFirstName());
        Assertions.assertEquals(human.getBirthDate(), humanDto.getBirthDate());
    }

    @Test
    void toHumanDtoTest() {
        Human human = Human.builder()
                .id(ID)
                .name("Test")
                .firstName("First")
                .birthDate(LocalDate.of(ID, ID, ID))
                .build();

        HumanDto humanDto = HumanMapper.INSTANCE.toHumanDto(human);

        Assertions.assertNotNull(humanDto);
        Assertions.assertEquals(humanDto.getId(), human.getId());
        Assertions.assertEquals(humanDto.getName(), human.getName());
        Assertions.assertEquals(humanDto.getFirstName(), human.getFirstName());
        Assertions.assertEquals(humanDto.getBirthDate(), human.getBirthDate());
    }

}
