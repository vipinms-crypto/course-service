package com.course.courseservice.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class CourseRequestDto {
	private String courseName;
	private String courseCode;
	private String courseDescription;
	private Integer courseNoModules;
	private Integer courseDuration;
	private Integer courseUserId;
	private List<ModuleRequestDto> moduleRequestDtos;
	
}
