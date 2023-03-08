package com.example.testtask.service;

import com.example.testtask.dto.HumanDto;

/**
 * Created by olegb on март, 2023
 */
public interface HumanService {

    HumanDto createHuman(HumanDto humanDto);
    HumanDto findById(int id);

}
