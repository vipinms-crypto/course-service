package com.course.courseservice.service;

import java.util.List;
import java.util.Optional;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;

public interface CourseService {

	 // Create a new course
    CourseResponseDto createCourse(CourseRequestDto courseRequestDto) throws Exception;

    // Get all courses
    List<CourseResponseDto> getAllCourses() throws Exception;

    // Get a course by ID
    Optional<CourseResponseDto> getCourseById(Integer id) throws Exception;

    // Update a course
    CourseResponseDto updateCourse(Integer id, CourseRequestDto courseRequestDto) throws Exception;

    // Delete a course
    boolean deleteCourse(Integer id) throws Exception;
}
