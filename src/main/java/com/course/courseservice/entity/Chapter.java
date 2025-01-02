package com.course.courseservice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "[chapter]", schema = "dbo")
public class Chapter {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;

    @Column(length = 50)
    private String chapterName;

    @Column(length = 50)
    private String chapterCode;

    @Column(length = 50)
    private String chapterDescription;

    @Column(name = "chapter_module_id", insertable = false, updatable = false)
    private Integer chapterModuleId;

    private Integer chapterDuration;

    @Column(length = 50)
    private String chapterCreatedBy;

    @CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime chapterCreatedDatetime;

    @Column(length = 50)
    private String chapterUpdatedBy;

    @UpdateTimestamp
	private LocalDateTime chapterUpdatedDatetime;
    
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Component component;

}
