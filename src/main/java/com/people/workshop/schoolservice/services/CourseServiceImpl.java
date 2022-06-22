package com.people.workshop.schoolservice.services;

import com.people.workshop.schoolservice.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.people.workshop.schoolservice.models.Course;
import com.people.workshop.schoolservice.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements GenericService<Course> {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {this.courseRepository = courseRepository;}

    @Override
    public List<Course> findAll() {return courseRepository.findAll();}

    @Override
    public List<Course> findByFormat(Pageable paging){
        Page<Course> pageResult = courseRepository.findAll(paging);

        if(pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Course>();
        }
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course Doesn't Exist"));}

    @Override
    public void add(Course course) {courseRepository.save(course);}

    @Override
    public void edit(int id, Course course) throws EntityNotFoundException {
        if (!courseRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Course Doesn't Exist");}
        course.setId(id);
        courseRepository.save(course);
        //return "Course "+course.getName()+" edited successfully";
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        if (!courseRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Course Doesn't Exist");
        }
        courseRepository.deleteById(id);
    }
}
