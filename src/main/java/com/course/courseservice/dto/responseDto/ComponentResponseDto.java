package com.course.courseservice.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class ComponentResponseDto {
	private int componentId;
    private String componentName;
    private String componentCode;
    private String componentDescription;
    private Integer componentNoChapters;
    private Integer componentDuration;
    private List<ChapterResponseDto> chapterRequestDtos;
}
