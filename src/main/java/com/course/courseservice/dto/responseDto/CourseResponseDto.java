package com.course.courseservice.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class CourseResponseDto {
	private Integer courseId;
	private String courseName;
	private String courseCode;
	private String courseDescription;
	private Integer courseNoModules;
	private Integer courseDuration;
	private Integer courseUserId;
	private List<ModuleResponseDto> moduleRequestDtos;
	
}
