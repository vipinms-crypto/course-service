package com.course.courseservice.dto.requestDto;

import java.util.Objects;

//@Data
public class CourseRequestDto {
	private String courseName;
	private String courseCode;
	private String courseDescription;
	private Integer courseNoModules;
	private Integer courseDuration;
	private Integer courseUserId;
	private ModuleRequestDto moduleRequestDto;
	private ChapterRequestDto chapterRequestDto;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Integer getCourseNoModules() {
		return courseNoModules;
	}
	public void setCourseNoModules(Integer courseNoModules) {
		this.courseNoModules = courseNoModules;
	}
	public Integer getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}
	public Integer getCourseUserId() {
		return courseUserId;
	}
	public void setCourseUserId(Integer courseUserId) {
		this.courseUserId = courseUserId;
	}
	public ModuleRequestDto getModuleRequestDto() {
		return moduleRequestDto;
	}
	public void setModuleRequestDto(ModuleRequestDto moduleRequestDto) {
		this.moduleRequestDto = moduleRequestDto;
	}
	public ChapterRequestDto getChapterRequestDto() {
		return chapterRequestDto;
	}
	public void setChapterRequestDto(ChapterRequestDto chapterRequestDto) {
		this.chapterRequestDto = chapterRequestDto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(chapterRequestDto, courseCode, courseDescription, courseDuration, courseName,
				courseNoModules, courseUserId, moduleRequestDto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseRequestDto other = (CourseRequestDto) obj;
		return Objects.equals(chapterRequestDto, other.chapterRequestDto)
				&& Objects.equals(courseCode, other.courseCode)
				&& Objects.equals(courseDescription, other.courseDescription)
				&& Objects.equals(courseDuration, other.courseDuration) && Objects.equals(courseName, other.courseName)
				&& Objects.equals(courseNoModules, other.courseNoModules)
				&& Objects.equals(courseUserId, other.courseUserId)
				&& Objects.equals(moduleRequestDto, other.moduleRequestDto);
	}
	@Override
	public String toString() {
		return "CourseRequestDto [courseName=" + courseName + ", courseCode=" + courseCode + ", courseDescription="
				+ courseDescription + ", courseNoModules=" + courseNoModules + ", courseDuration=" + courseDuration
				+ ", courseUserId=" + courseUserId + ", moduleRequestDto=" + moduleRequestDto + ", chapterRequestDto="
				+ chapterRequestDto + "]";
	}
	

}
