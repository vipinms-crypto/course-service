package com.course.courseservice.entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="course")
public class Course {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private String courseCode;
    private String courseDescription;
    private Integer courseNoModules;
    private Integer courseDuration;
    private Integer courseUserId;
    private String courseCreatedBy;
    private String courseUpdatedBy;
    private Date courseCreatedDatetime;
    private Date courseUpdatedDatetime;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Module> modules;
    
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
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
	public String getCourseCreatedBy() {
		return courseCreatedBy;
	}
	public void setCourseCreatedBy(String courseCreatedBy) {
		this.courseCreatedBy = courseCreatedBy;
	}
	public String getCourseUpdatedBy() {
		return courseUpdatedBy;
	}
	public void setCourseUpdatedBy(String courseUpdatedBy) {
		this.courseUpdatedBy = courseUpdatedBy;
	}
	public Date getCourseCreatedDatetime() {
		return courseCreatedDatetime;
	}
	public void setCourseCreatedDatetime(Date courseCreatedDatetime) {
		this.courseCreatedDatetime = courseCreatedDatetime;
	}
	public Date getCourseUpdatedDatetime() {
		return courseUpdatedDatetime;
	}
	public void setCourseUpdatedDatetime(Date courseUpdatedDatetime) {
		this.courseUpdatedDatetime = courseUpdatedDatetime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseCode, courseCreatedBy, courseCreatedDatetime, courseDescription, courseDuration,
				courseId, courseName, courseNoModules, courseUpdatedBy, courseUpdatedDatetime, courseUserId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseCode, other.courseCode) && Objects.equals(courseCreatedBy, other.courseCreatedBy)
				&& Objects.equals(courseCreatedDatetime, other.courseCreatedDatetime)
				&& Objects.equals(courseDescription, other.courseDescription)
				&& Objects.equals(courseDuration, other.courseDuration) && Objects.equals(courseId, other.courseId)
				&& Objects.equals(courseName, other.courseName)
				&& Objects.equals(courseNoModules, other.courseNoModules)
				&& Objects.equals(courseUpdatedBy, other.courseUpdatedBy)
				&& Objects.equals(courseUpdatedDatetime, other.courseUpdatedDatetime)
				&& Objects.equals(courseUserId, other.courseUserId);
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCode=" + courseCode
				+ ", courseDescription=" + courseDescription + ", courseNoModules=" + courseNoModules
				+ ", courseDuration=" + courseDuration + ", courseUserId=" + courseUserId + ", courseCreatedBy="
				+ courseCreatedBy + ", courseUpdatedBy=" + courseUpdatedBy + ", courseCreatedDatetime="
				+ courseCreatedDatetime + ", courseUpdatedDatetime=" + courseUpdatedDatetime + "]";
	}
    

}
