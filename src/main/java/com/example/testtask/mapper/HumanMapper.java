package com.example.testtask.mapper;


import com.example.testtask.dto.HumanDto;
import com.example.testtask.model.Human;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * Created by olegb on март, 2023
 */


@Mapper
public interface HumanMapper {

    HumanMapper INSTANCE = Mappers.getMapper(HumanMapper.class);

    Human toHuman(HumanDto humanDto);

    HumanDto toHumanDto(Human human);

}
