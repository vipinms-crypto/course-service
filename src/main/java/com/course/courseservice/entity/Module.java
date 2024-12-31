package com.course.courseservice.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name ="module")
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

    @Temporal(TemporalType.DATE)
    private Date moduleCreatedDatetime;

    @Column(length = 50)
    private String moduleUpdatedBy;

    @Temporal(TemporalType.DATE)
    private Date moduleUpdatedDatetime;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chapter> chapters;

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public Integer getModuleNoChapters() {
		return moduleNoChapters;
	}

	public void setModuleNoChapters(Integer moduleNoChapters) {
		this.moduleNoChapters = moduleNoChapters;
	}

	public Integer getModuleDuration() {
		return moduleDuration;
	}

	public void setModuleDuration(Integer moduleDuration) {
		this.moduleDuration = moduleDuration;
	}

	public Integer getModuleCourseId() {
		return moduleCourseId;
	}

	public void setModuleCourseId(Integer moduleCourseId) {
		this.moduleCourseId = moduleCourseId;
	}

	public String getModuleCreatedBy() {
		return moduleCreatedBy;
	}

	public void setModuleCreatedBy(String moduleCreatedBy) {
		this.moduleCreatedBy = moduleCreatedBy;
	}

	public Date getModuleCreatedDatetime() {
		return moduleCreatedDatetime;
	}

	public void setModuleCreatedDatetime(Date moduleCreatedDatetime) {
		this.moduleCreatedDatetime = moduleCreatedDatetime;
	}

	public String getModuleUpdatedBy() {
		return moduleUpdatedBy;
	}

	public void setModuleUpdatedBy(String moduleUpdatedBy) {
		this.moduleUpdatedBy = moduleUpdatedBy;
	}

	public Date getModuleUpdatedDatetime() {
		return moduleUpdatedDatetime;
	}

	public void setModuleUpdatedDatetime(Date moduleUpdatedDatetime) {
		this.moduleUpdatedDatetime = moduleUpdatedDatetime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(moduleCode, moduleCourseId, moduleCreatedBy, moduleCreatedDatetime, moduleDescription,
				moduleDuration, moduleId, moduleName, moduleNoChapters, moduleUpdatedBy, moduleUpdatedDatetime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		return Objects.equals(moduleCode, other.moduleCode) && Objects.equals(moduleCourseId, other.moduleCourseId)
				&& Objects.equals(moduleCreatedBy, other.moduleCreatedBy)
				&& Objects.equals(moduleCreatedDatetime, other.moduleCreatedDatetime)
				&& Objects.equals(moduleDescription, other.moduleDescription)
				&& Objects.equals(moduleDuration, other.moduleDuration) && moduleId == other.moduleId
				&& Objects.equals(moduleName, other.moduleName)
				&& Objects.equals(moduleNoChapters, other.moduleNoChapters)
				&& Objects.equals(moduleUpdatedBy, other.moduleUpdatedBy)
				&& Objects.equals(moduleUpdatedDatetime, other.moduleUpdatedDatetime);
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", moduleCode=" + moduleCode
				+ ", moduleDescription=" + moduleDescription + ", moduleNoChapters=" + moduleNoChapters
				+ ", moduleDuration=" + moduleDuration + ", moduleCourseId=" + moduleCourseId + ", moduleCreatedBy="
				+ moduleCreatedBy + ", moduleCreatedDatetime=" + moduleCreatedDatetime + ", moduleUpdatedBy="
				+ moduleUpdatedBy + ", moduleUpdatedDatetime=" + moduleUpdatedDatetime + "]";
	}
    
}
