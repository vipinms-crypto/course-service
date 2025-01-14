package com.course.courseservice.service;

import java.util.List;
import java.util.Optional;

import com.course.courseservice.entity.UserCourseMapping;
import com.course.courseservice.model.SearchCriteria;

public interface UserCourseMappingService {

	List<UserCourseMapping> getAllCourseUserMapping();

	Optional<UserCourseMapping> getCourseUserMappingById(Integer id);

	UserCourseMapping createCourseUserMapping(UserCourseMapping userCourseMapping);

	UserCourseMapping updateCourseUserMapping(Integer id, UserCourseMapping userCourseMapping);

	Boolean deleteCourseUserMapping(Integer id);
	
	List<UserCourseMapping> searchUserMapping(SearchCriteria searchCriteria);

}
