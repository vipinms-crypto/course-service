package com.course.courseservice.dto.requestDto;

import java.util.Objects;

public class ModuleRequestDto {
    private String moduleName;
    private String moduleCode;
    private String moduleDescription;
    private Integer moduleNoChapters;
    private Integer moduleDuration;
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
	@Override
	public int hashCode() {
		return Objects.hash(moduleCode, moduleDescription, moduleDuration, moduleName, moduleNoChapters);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleRequestDto other = (ModuleRequestDto) obj;
		return Objects.equals(moduleCode, other.moduleCode)
				&& Objects.equals(moduleDescription, other.moduleDescription)
				&& Objects.equals(moduleDuration, other.moduleDuration) && Objects.equals(moduleName, other.moduleName)
				&& Objects.equals(moduleNoChapters, other.moduleNoChapters);
	}
	@Override
	public String toString() {
		return "ModuleRequestDto [moduleName=" + moduleName + ", moduleCode=" + moduleCode + ", moduleDescription="
				+ moduleDescription + ", moduleNoChapters=" + moduleNoChapters + ", moduleDuration=" + moduleDuration
				+ "]";
	}
    
    

}
