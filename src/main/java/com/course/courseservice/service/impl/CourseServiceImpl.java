package com.course.courseservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;
import com.course.courseservice.entity.Course;
import com.course.courseservice.mapper.CourseMapper;
import com.course.courseservice.repository.CourseRepository;
import com.course.courseservice.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
	private CourseMapper courseMapper;

    @Override
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) throws Exception {
        Course course = courseMapper.toEntity(courseRequestDto);
        Course savedCourse = courseRepository.save(course);
        return mapToResponseDto(savedCourse);
    }

    @Override
    public List<CourseResponseDto> getAllCourses() throws Exception{
        return courseRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CourseResponseDto> getCourseById(Integer id) throws Exception{
        return courseRepository.findById(id)
                .map(this::mapToResponseDto);
    }

    @Override
    public CourseResponseDto updateCourse(Integer id, CourseRequestDto courseRequestDto) throws Exception{
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course = courseMapper.toEntity(courseRequestDto);
            Course updatedCourse = courseRepository.save(course);
            return  courseMapper.toDto(updatedCourse);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public boolean deleteCourse(Integer id) throws Exception{
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false; // Or throw an exception
        }
    }

    private CourseResponseDto mapToResponseDto(Course course) {
    	return courseMapper.toDto(course);
    }
}
