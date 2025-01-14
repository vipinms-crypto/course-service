package com.course.courseservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseservice.entity.UserCourseMapping;
import com.course.courseservice.exception.ResourceNotFoundException;
import com.course.courseservice.model.SearchCriteria;
import com.course.courseservice.repository.UserCourseMappingRepository;
import com.course.courseservice.service.UserCourseMappingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserCourseMappingServiceImpl implements UserCourseMappingService{
	
	@Autowired
	UserCourseMappingRepository userCourseMappingRepository;

	@Override
	public List<UserCourseMapping> getAllCourseUserMapping() {
		log.info("Entered into service method getAllCourseUserMapping");
		return userCourseMappingRepository.findAll();
	}

	@Override
	public Optional<UserCourseMapping> getCourseUserMappingById(Integer id) {
		log.info("Entered into service method getCourseUserMappingById");
		return userCourseMappingRepository.findById(id);
	}

	@Override
	public UserCourseMapping createCourseUserMapping(UserCourseMapping userCourseMapping) {
		log.info("Entered into service method createCourseUserMapping");
		return userCourseMappingRepository.save(userCourseMapping);
	}

	@Override
    public UserCourseMapping updateCourseUserMapping(Integer id, UserCourseMapping userCourseMapping) {
		log.info("Entered into service method updateCourseUserMapping");
        Optional<UserCourseMapping> optionalMapping = userCourseMappingRepository.findById(id);
        if (optionalMapping.isPresent()) {
            UserCourseMapping existingMapping = optionalMapping.get();
            existingMapping.setUserCourseMappingUserId(userCourseMapping.getUserCourseMappingUserId());
            existingMapping.setUserCourseMappingUserId(userCourseMapping.getUserCourseMappingCourseId());
            return userCourseMappingRepository.save(existingMapping);
        } else {
            throw new ResourceNotFoundException("Mapping not found with id " + id);
        }
    }

	 @Override
	    public Boolean deleteCourseUserMapping(Integer id) {
		 log.info("Entered into service method deleteCourseUserMapping");
	        if (userCourseMappingRepository.existsById(id)) {
	            userCourseMappingRepository.deleteById(id);
	            return true;
	        } else {
	            throw new ResourceNotFoundException("Mapping not found with id " + id);
	        }
	    }

	@Override
	public List<UserCourseMapping> searchUserMapping(SearchCriteria searchCriteria) {
		log.info("Entered into service method searchUserMapping");
		/**
		 * As of searchCriteria is not used
		 * Can be extend to future search.
		 */
		Optional<List<UserCourseMapping>> lstmapping =  userCourseMappingRepository.findByUserCourseMappingUserId(Integer.valueOf(searchCriteria.getSearchObject().getInputValue()));
		if(Optional.empty() != null) {
			return lstmapping.get();
		}
		return null;
		
	}

	

}
