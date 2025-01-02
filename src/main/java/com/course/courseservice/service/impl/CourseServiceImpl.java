package com.course.courseservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;
import com.course.courseservice.entity.Course;
import com.course.courseservice.exception.ResourceNotFoundException;
import com.course.courseservice.mapper.CourseMapper;
import com.course.courseservice.repository.CourseRepository;
import com.course.courseservice.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
	
	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
	private CourseMapper courseMapper;

    @Override
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) throws Exception {
    	log.info("Entered into service method createCourse");
        Course course = courseMapper.toEntity(courseRequestDto);
        Course savedCourse = courseRepository.save(course);
        log.info("Exit from service method createCourse");
        return mapToResponseDto(savedCourse);
    }

    @Override
    public List<CourseResponseDto> getAllCourses() throws Exception{
    	log.info("Entered into service method getAllCourses");
        return courseRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CourseResponseDto> getCourseById(Integer id) throws Exception{
    	log.info("Entered into service method getCourseById");
        return courseRepository.findById(id)
                .map(this::mapToResponseDto);
    }

    @Override
    public CourseResponseDto updateCourse(Integer id, CourseRequestDto courseRequestDto) throws Exception{
    	log.info("Entered into service method updateCourse");
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            courseMapper.updateCourseFromDto(courseRequestDto, course);
            Course updatedCourse = courseRepository.save(course);
            log.info("Exit from service method updateCourse with response ,"+ updatedCourse);
            return  courseMapper.toDto(updatedCourse);
        } else {
        	log.info("No Course data found for given id,"+id);
        	throw new ResourceNotFoundException("No data found");
        }
    }

    @Override
    public boolean deleteCourse(Integer id) throws Exception{
    	log.info("Entered into service method deleteCourse");
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            log.info("Entered into service method deleteCourse");
            return true;
        } else {
        	log.info("No Course data found for given id,"+id);
        	throw new ResourceNotFoundException("No data found");
        }
    }

    private CourseResponseDto mapToResponseDto(Course course) {
    	log.info("Entered into service method mapToResponseDto");
    	return courseMapper.toDto(course);
    }
}
