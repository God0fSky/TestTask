package com.example.testtask.repository;


import com.example.testtask.model.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;


/**
 * Created by olegb on март, 2023
 */


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HumanRepositoryTest {

    @Autowired
    private HumanRepository humanRepository;


    @Test
    void saveHumanTest() {
        Human human = Human.builder()
                .name("Name")
                .firstName("FirstName")
                .birthDate(LocalDate.now())
                .build();

        humanRepository.save(human);

        Assertions.assertTrue(human.getId() > 0);
    }

    @Test
    void findHumanByIdTest() {
        Human human = Human.builder()
                .name("Name")
                .firstName("FirstName")
                .birthDate(LocalDate.now())
                .build();
        humanRepository.save(human);

        Human expected = humanRepository.findById(human.getId()).get();

        Assertions.assertEquals(expected, human);
    }

}
