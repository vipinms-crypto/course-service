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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "[module]", schema = "dbo")
public class Component {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_Id")
	private Integer componentId;

	@Column(name = "module_name", nullable = false)
	private String componentName;

	@Column(name = "module_code", nullable = false)
	private String componentCode;

	@Column(name = "module_description")
	private String componentDescription;

	@Column(name = "module_no_chapters")
	private Integer componentNoChapters;

	@Column(name = "module_duration")
	private Integer componentDuration;

	@Column(name = "module_course_id", insertable = false, updatable = false)
	private Integer componentCourseId;

	@Column(name = "module_created_by")
	private String componentCreatedBy;

	@CreationTimestamp
	@Column(name = "module_created_datetime", updatable = false)
	private LocalDateTime componentCreatedDatetime;

	@Column(name = "module_updated_by")
	private String componentUpdatedBy;

	@UpdateTimestamp
	@Column(name = "module_updated_datetime")
	private LocalDateTime componentUpdatedDatetime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;

	@OneToMany(mappedBy = "component", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Chapter> chapters;
}
