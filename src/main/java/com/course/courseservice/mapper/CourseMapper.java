package com.course.courseservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;
import com.course.courseservice.entity.Course;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {
		ComponentMapper.class })
public interface CourseMapper {
	void updateCourseFromDto(CourseRequestDto reqDto, @MappingTarget Course course);

	@Mapping(target = "components", source = "componentRequestDto")
	Course toCourseEntity(CourseRequestDto dto);

	@Mapping(target = "componentResponseDto", source = "components")
	CourseResponseDto toCourseResponseDto(Course course);

	List<CourseResponseDto> toResponseDtoList(List<Course> courses);
}