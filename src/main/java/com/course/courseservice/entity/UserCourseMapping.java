package com.course.courseservice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "[user-course-mapping]", schema = "dbo")
public class UserCourseMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userCourseMappingId;
	
	private Integer userCourseMappingUserId;
	private Integer userCourseMappingCourseId;

	private String courseCreatedBy;
	private String courseUpdatedBy;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime courseCreatedDatetime;

	@UpdateTimestamp
	private LocalDateTime courseUpdatedDatetime;
}
