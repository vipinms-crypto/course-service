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

import com.course.courseservice.entity.UserCourseMapping;
import com.course.courseservice.model.SearchCriteria;
import com.course.courseservice.service.UserCourseMappingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/courses")
@Tag(name = "Course User Mapping API", description = "API for managing user course mapping")
public class UserCourseMappingController {

	@Autowired
	private UserCourseMappingService userCourseMappingService;

	@GetMapping("/user/mapping")
	@Operation(summary = "Fetch all Course User Mapping", description = "Retrieve a list of all Course User Mapping")
	public List<UserCourseMapping> getAllCourseUserMapping() throws Exception {
		log.info("Entered into getAllCourseUserMapping");
		return userCourseMappingService.getAllCourseUserMapping();
	}

	@GetMapping("/user/mapping/{id}")
	@Operation(summary = "Fetch a Course User Mapping", description = "Retrieve a course user mapping by passing its ID")
	public ResponseEntity<UserCourseMapping> getCourseUserMappingById(@PathVariable Integer id) throws Exception {
		log.info("Entered into getCourseUserMappingById");
		Optional<UserCourseMapping> course = userCourseMappingService.getCourseUserMappingById(id);
		return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/user/mapping")
	@Operation(summary = "Persist Course User Mapping", description = "Persist course user mapping data")
	public ResponseEntity<UserCourseMapping> createCourseUserMapping(@RequestBody UserCourseMapping userCourseMappingReq) throws Exception {
		log.info("Entered into createCourseUserMapping");
		UserCourseMapping userCourseMapping = userCourseMappingService.createCourseUserMapping(userCourseMappingReq);
		return ResponseEntity.ok(userCourseMapping);
	}

	@PutMapping("/user/mapping/{id}")
	@Operation(summary = "Update course user mapping", description = "Update a course user mapping by passing its ID")
	public ResponseEntity<UserCourseMapping> updateCourseUserMapping(@PathVariable Integer id,
			@RequestBody UserCourseMapping userCourseMappingReq) throws Exception {
		log.info("Entered into updateCourseUserMapping");
		UserCourseMapping resDto = userCourseMappingService.updateCourseUserMapping(id, userCourseMappingReq);
		return ResponseEntity.ok(resDto);
	}

    @DeleteMapping("/user/mapping/{id}")
    @Operation(summary = "Delete course user mapping", description = "Delete a course user mapping by passing its ID")
    public ResponseEntity<Boolean> deleteCourseUserMapping(@PathVariable Integer id) throws Exception {
    	log.info("Entered into deleteCourseUserMapping");
		return ResponseEntity.ok(userCourseMappingService.deleteCourseUserMapping(id));
    }
    @PostMapping("/user/mapping/search")
	@Operation(summary = "Search Course User Mapping", description = "Search course user mapping data")
	public ResponseEntity<List<UserCourseMapping>> searchCourseUserMapping(@RequestBody SearchCriteria searchCriteria) throws Exception {
		log.info("Entered into searchCourseUserMapping");
		List<UserCourseMapping> userCourseMapping = userCourseMappingService.searchUserMapping(searchCriteria);
		return ResponseEntity.ok(userCourseMapping);
	}
}