package com.people.workshop.schoolservice.controllers;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

import com.people.workshop.schoolservice.services.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import com.people.workshop.schoolservice.models.Course;

@Validated
@RestController
@RequestMapping(path="/courses")
public class CourseController {

    private GenericService<Course> courseService;

    public CourseController(GenericService<Course> courseService) {this.courseService = courseService;}

    @GetMapping(value="/all")
    public List<Course> findAll(){return courseService.findAll();}

    @GetMapping
    public List<Course> findByFormat(Pageable paging) {
        return courseService.findByFormat(paging);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable @Min(1) int id){return courseService.findById(id);}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void add(@Valid @RequestBody Course course){courseService.add(course);}

    @PutMapping("/{id}")
    public void edit(@Valid @PathVariable int id, @RequestBody Course course){courseService.edit(id, course);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){courseService.delete(id);}
}