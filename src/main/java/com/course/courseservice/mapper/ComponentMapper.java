package com.course.courseservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.course.courseservice.dto.requestDto.ChapterRequestDto;
import com.course.courseservice.dto.requestDto.ComponentRequestDto;
import com.course.courseservice.dto.responseDto.ComponentResponseDto;
import com.course.courseservice.entity.Chapter;
import com.course.courseservice.entity.Component;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,uses = {ChapterMapper.class})
public interface ComponentMapper {

	@Mapping(target = "chapters", source = "chapterRequestDto")
	Component toEntity(ComponentRequestDto dto);

    @Mapping(target = "component", ignore = true)
    Chapter toEntity(ChapterRequestDto dto);
    
    @Mapping(target = "chapterRequestDtos", source = "chapters")
    ComponentResponseDto toResponseDto(Component component);

    List<ComponentResponseDto> toResponseDtoList(List<Component> components);
}
