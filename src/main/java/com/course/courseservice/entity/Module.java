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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moduleId;

    @Column(nullable = false, length = 50)
    private String moduleName;

    @Column(length = 50)
    private String moduleCode;

    @Column(length = 50)
    private String moduleDescription;

    private Integer moduleNoChapters;

    private Integer moduleDuration;

    private Integer moduleCourseId;

    @Column(length = 50)
    private String moduleCreatedBy;

    @CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime moduleCreatedDatetime;

    @Column(length = 50)
    private String moduleUpdatedBy;

    @UpdateTimestamp
	private LocalDateTime moduleUpdatedDatetime;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chapter> chapters;

}
