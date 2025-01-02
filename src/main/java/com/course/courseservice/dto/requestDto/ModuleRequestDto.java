package com.course.courseservice.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class ModuleRequestDto {
    private String moduleName;
    private String moduleCode;
    private String moduleDescription;
    private Integer moduleNoChapters;
    private Integer moduleDuration;
    private List<ChapterRequestDto> chapterRequestDto;
}
