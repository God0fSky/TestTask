package com.example.testtask;

import com.example.testtask.dto.HumanDto;
import com.example.testtask.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class TestTaskApplication {

    @Autowired
    private HumanService humanService;

    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        /*humanService.createHuman(new HumanDto(null, "Test", "Human",
                        LocalDate.of(2003, Month.JULY, 23), 0));*/
    }

}
