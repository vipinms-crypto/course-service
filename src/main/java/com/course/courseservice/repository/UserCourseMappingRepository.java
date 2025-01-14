package com.course.courseservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.courseservice.entity.UserCourseMapping;

@Repository
public interface UserCourseMappingRepository extends JpaRepository<UserCourseMapping, Integer> {
	Optional<List<UserCourseMapping>> findByUserCourseMappingUserId(Integer userCourseMappingUserId);
}
