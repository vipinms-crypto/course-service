package com.course.courseservice.dto.responseDto;

import lombok.Data;

@Data
public class ChapterResponseDto {
	private int chapterId;
    private String chapterName;
    private String chapterCode;
    private String chapterDescription;
    private Integer chapterModuleId;
    private Integer chapterDuration;
}
