package com.course.courseservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "[course]", schema = "dbo")
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
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime courseCreatedDatetime;

	@UpdateTimestamp
	private LocalDateTime courseUpdatedDatetime;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Component> components;

}
