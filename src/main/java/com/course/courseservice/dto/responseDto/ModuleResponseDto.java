package com.course.courseservice.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class ModuleResponseDto {
	private int moduleId;
    private String moduleName;
    private String moduleCode;
    private String moduleDescription;
    private Integer moduleNoChapters;
    private Integer moduleDuration;
    private List<ChapterResponseDto> chapterRequestDtos;
}
