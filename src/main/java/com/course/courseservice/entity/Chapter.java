package com.course.courseservice.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
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

    private Integer chapterModuleId;

    private Integer chapterDuration;

    @Column(length = 50)
    private String chapterCreatedBy;

    @Temporal(TemporalType.DATE)
    private Date chapterCreatedDatetime;

    @Column(length = 50)
    private String chapterUpdatedBy;

    @Temporal(TemporalType.DATE)
    private Date chapterUpdatedDatetime;
    
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

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

	public String getChapterCreatedBy() {
		return chapterCreatedBy;
	}

	public void setChapterCreatedBy(String chapterCreatedBy) {
		this.chapterCreatedBy = chapterCreatedBy;
	}

	public Date getChapterCreatedDatetime() {
		return chapterCreatedDatetime;
	}

	public void setChapterCreatedDatetime(Date chapterCreatedDatetime) {
		this.chapterCreatedDatetime = chapterCreatedDatetime;
	}

	public String getChapterUpdatedBy() {
		return chapterUpdatedBy;
	}

	public void setChapterUpdatedBy(String chapterUpdatedBy) {
		this.chapterUpdatedBy = chapterUpdatedBy;
	}

	public Date getChapterUpdatedDatetime() {
		return chapterUpdatedDatetime;
	}

	public void setChapterUpdatedDatetime(Date chapterUpdatedDatetime) {
		this.chapterUpdatedDatetime = chapterUpdatedDatetime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chapterCode, chapterCreatedBy, chapterCreatedDatetime, chapterDescription, chapterDuration,
				chapterId, chapterModuleId, chapterName, chapterUpdatedBy, chapterUpdatedDatetime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapter other = (Chapter) obj;
		return Objects.equals(chapterCode, other.chapterCode)
				&& Objects.equals(chapterCreatedBy, other.chapterCreatedBy)
				&& Objects.equals(chapterCreatedDatetime, other.chapterCreatedDatetime)
				&& Objects.equals(chapterDescription, other.chapterDescription)
				&& Objects.equals(chapterDuration, other.chapterDuration) && chapterId == other.chapterId
				&& Objects.equals(chapterModuleId, other.chapterModuleId)
				&& Objects.equals(chapterName, other.chapterName)
				&& Objects.equals(chapterUpdatedBy, other.chapterUpdatedBy)
				&& Objects.equals(chapterUpdatedDatetime, other.chapterUpdatedDatetime);
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", chapterName=" + chapterName + ", chapterCode=" + chapterCode
				+ ", chapterDescription=" + chapterDescription + ", chapterModuleId=" + chapterModuleId
				+ ", chapterDuration=" + chapterDuration + ", chapterCreatedBy=" + chapterCreatedBy
				+ ", chapterCreatedDatetime=" + chapterCreatedDatetime + ", chapterUpdatedBy=" + chapterUpdatedBy
				+ ", chapterUpdatedDatetime=" + chapterUpdatedDatetime + "]";
	}
    
}
