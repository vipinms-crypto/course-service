package com.course.courseservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseservice.dto.requestDto.CourseRequestDto;
import com.course.courseservice.dto.responseDto.CourseResponseDto;
import com.course.courseservice.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/courses")
@Tag(name = "Course API", description = "API for managing courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	@Operation(summary = "Fetch all courses", description = "Retrieve a list of all courses")
	public List<CourseResponseDto> getAllCourses() throws Exception {
		log.info("Entered into getAllCourses");
		return courseService.getAllCourses();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Fetch a course", description = "Retrieve a course by passing its ID")
	public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Integer id) throws Exception {
		log.info("Entered into getCourseById");
		Optional<CourseResponseDto> course = courseService.getCourseById(id);
		return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Persist course", description = "Persist course data")
	public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseReqDto) throws Exception {
		log.info("Entered into createCourse");
		CourseResponseDto resDto = courseService.createCourse(courseReqDto);
		return ResponseEntity.ok(resDto);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update course", description = "Update a course by passing its ID")
	public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Integer id,
			@RequestBody CourseRequestDto courseReqDto) throws Exception {
		log.info("Entered into updateCourse");
		CourseResponseDto resDto = courseService.updateCourse(id, courseReqDto);
		return ResponseEntity.ok(resDto);
	}

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete course", description = "Delete a course by passing its ID")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable Integer id) throws Exception {
    	log.info("Entered into deleteCourse");
		return ResponseEntity.ok(courseService.deleteCourse(id));
    }
}