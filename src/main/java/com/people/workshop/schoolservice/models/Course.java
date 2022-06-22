package com.people.workshop.schoolservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 40)
    @NotEmpty
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "course", cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Student> students;

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public List<Student> getStudents() {return students;}

    public void setStudents(List<Student> students) {this.students = students;}

    public List<String> getStudentName(){
        return students.stream().map(s -> s.getFirstname() + " " + s.getLastname()).collect(Collectors.toList());
    }
}
