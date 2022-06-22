package com.people.workshop.schoolservice.controllers;

import com.people.workshop.schoolservice.models.Student;
import com.people.workshop.schoolservice.services.GenericService;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path="/students")
public class StudentController {

    private GenericService<Student> studentService;

    public StudentController(GenericService<Student> studentService) {this.studentService = studentService;}

    @GetMapping(value="/all")
    public List<Student> findAll(){return studentService.findAll(); }

    @GetMapping
    public List<Student> findByFormat(Pageable paging) {return studentService.findByFormat(paging); }

    @GetMapping("/{id}")
    public Student getById(@PathVariable @Min(1) int id){return studentService.findById(id);}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping public void add(@Valid @RequestBody Student student){studentService.add(student);}

    @PutMapping("/{id}")
    public void edit(@Valid @PathVariable int id, @RequestBody Student student){studentService.edit(id, student);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){studentService.delete(id);}
}