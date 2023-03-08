package com.example.testtask.controller;

import com.example.testtask.dto.HumanDto;
import com.example.testtask.service.HumanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by olegb on март, 2023
 */

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class HumanController {

    private final HumanServiceImpl humanService;

    @GetMapping("/{id}")
    public HumanDto getHuman(@PathVariable int id) {
        if(id < 0) {
            throw new IllegalArgumentException("Id < 0");
        }
        return humanService.findById(id);
    }

}
