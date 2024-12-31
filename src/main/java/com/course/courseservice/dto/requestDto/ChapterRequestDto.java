package com.course.courseservice.dto.requestDto;

import java.util.Objects;

public class ChapterRequestDto {
    private String chapterName;
    private String chapterCode;
    private String chapterDescription;
    private Integer chapterModuleId;
    private Integer chapterDuration;
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getChapterCode() {
		return chapterCode;
	}
	public void setChapterCode(String chapterCode) {
		this.chapterCode = chapterCode;
	}
	public String getChapterDescription() {
		return chapterDescription;
	}
	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}
	public Integer getChapterModuleId() {
		return chapterModuleId;
	}
	public void setChapterModuleId(Integer chapterModuleId) {
		this.chapterModuleId = chapterModuleId;
	}
	public Integer getChapterDuration() {
		return chapterDuration;
	}
	public void setChapterDuration(Integer chapterDuration) {
		this.chapterDuration = chapterDuration;
	}
	@Override
	public int hashCode() {
		return Objects.hash(chapterCode, chapterDescription, chapterDuration, chapterModuleId, chapterName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChapterRequestDto other = (ChapterRequestDto) obj;
		return Objects.equals(chapterCode, other.chapterCode)
				&& Objects.equals(chapterDescription, other.chapterDescription)
				&& Objects.equals(chapterDuration, other.chapterDuration)
				&& Objects.equals(chapterModuleId, other.chapterModuleId)
				&& Objects.equals(chapterName, other.chapterName);
	}
	@Override
	public String toString() {
		return "ChapterRequestDto [chapterName=" + chapterName + ", chapterCode=" + chapterCode
				+ ", chapterDescription=" + chapterDescription + ", chapterModuleId=" + chapterModuleId
				+ ", chapterDuration=" + chapterDuration + "]";
	}
    
}
