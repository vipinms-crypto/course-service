package com.course.courseservice.dto.requestDto;

import lombok.Data;

@Data
public class ChapterRequestDto {
    private String chapterName;
    private String chapterCode;
    private String chapterDescription;
    private Integer chapterModuleId;
    private Integer chapterDuration;
}
