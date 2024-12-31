package com.course.courseservice.mapper;

import org.mapstruct.Mapper;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;
import com.course.courseservice.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseRequestDto reqDto);
    CourseResponseDto toDto(Course course);
}