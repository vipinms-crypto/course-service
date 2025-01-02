package com.course.courseservice.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class ComponentRequestDto {
    private String componentName;
    private String componentCode;
    private String componentDescription;
    private Integer componentNoChapters;
    private Integer componentDuration;
    private List<ChapterRequestDto> chapterRequestDto;
}
