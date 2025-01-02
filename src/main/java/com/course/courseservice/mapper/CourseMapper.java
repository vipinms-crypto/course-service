package com.course.courseservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;
import com.course.courseservice.entity.Course;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseMapper {
    Course toEntity(CourseRequestDto reqDto);
    CourseResponseDto toDto(Course course);
	void updateCourseFromDto(CourseRequestDto reqDto, @MappingTarget Course course);

}