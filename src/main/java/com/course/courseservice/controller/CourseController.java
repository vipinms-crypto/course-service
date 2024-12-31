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
@Tag(name = "User API", description = "API for managing users")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	@Operation(summary = "Fetch all users", description = "Retrieve a list of all users")

	public List<CourseResponseDto> getAllCourses() throws Exception {
//		log.info("An INFO message");
		System.out.println("Entered");
		return courseService.getAllCourses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Integer id) throws Exception {
		Optional<CourseResponseDto> course = courseService.getCourseById(id);
		return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseReqDto) throws Exception {
		CourseResponseDto resDto = courseService.createCourse(courseReqDto);
		return ResponseEntity.ok(resDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Integer id,
			@RequestBody CourseRequestDto courseReqDto) throws Exception {
		CourseResponseDto resDto = courseService.updateCourse(id, courseReqDto);
		return ResponseEntity.ok(resDto);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(courseService.deleteCourse(id));
    }
}