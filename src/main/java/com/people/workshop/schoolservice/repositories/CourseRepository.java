package com.people.workshop.schoolservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.people.workshop.schoolservice.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
}
