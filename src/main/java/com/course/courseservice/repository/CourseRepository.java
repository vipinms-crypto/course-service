package com.course.courseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course.courseservice.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	List<Course> findByCourseUserId(Integer courseUserId);
	
	@Query(value = "SELECT * FROM course WHERE course_id IN :courseIds", nativeQuery = true)
	List<Course> findByCourseIdList(@Param("courseIds") List<Integer> courseIds);

}
