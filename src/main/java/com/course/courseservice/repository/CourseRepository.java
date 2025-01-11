package com.course.courseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.courseservice.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	List<Course> findByCourseUserId(Integer courseUserId);

}
