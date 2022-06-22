package com.people.workshop.schoolservice.services;

import com.people.workshop.schoolservice.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.people.workshop.schoolservice.models.Student;
import com.people.workshop.schoolservice.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements GenericService<Student> {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByFormat(Pageable paging){
        Page<Student> pageResult = studentRepository.findAll(paging);

        if(pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Student>();
        }
    }
    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student Doesn't Exist"));
    }

    @Override
    public void add(Student student) {
        studentRepository.save(student);}

    @Override
    public void edit(int id, Student student) throws EntityNotFoundException {
        if (!studentRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Student Doesn't Exist");}
        student.setId(id);
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        if (!studentRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Student Doesn't Exist");
        }
        studentRepository.deleteById(id);
    }

}
