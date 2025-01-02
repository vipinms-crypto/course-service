package com.course.courseservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.course.courseservice.dto.responseDto.ChapterResponseDto;
import com.course.courseservice.entity.Chapter;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChapterMapper {
	
	ChapterResponseDto toResponseDto(Chapter chapter);
    List<ChapterResponseDto> toResponseDtoList(List<Chapter> chapters);
}
