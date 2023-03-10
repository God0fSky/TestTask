package com.example.testtask.service;


import com.example.testtask.dto.HumanDto;
import com.example.testtask.mapper.HumanMapper;
import com.example.testtask.model.Human;
import com.example.testtask.repository.HumanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;


/**
 * Created by olegb on март, 2023
 */


@Service
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;


    @Override
    public HumanDto createHuman(HumanDto humanDto) {
        if (humanDto == null) {
            throw new NullPointerException("HumanDto is null!");
        }
        Human human = HumanMapper.INSTANCE.toHuman(humanDto);
        humanRepository.save(human);
        humanDto.setId(human.getId());
        return humanDto;
    }

    @Override
    public HumanDto findById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id < 0");
        }
        Human human = humanRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id=" + id + " wasn`t found"));
        HumanDto humanDto = HumanMapper.INSTANCE.toHumanDto(human);
        humanDto.setAge(Period.between(humanDto.getBirthDate(), LocalDate.now()).getYears());
        return humanDto;
    }

}
