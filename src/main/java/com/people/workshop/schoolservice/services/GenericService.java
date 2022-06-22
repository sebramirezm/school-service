package com.people.workshop.schoolservice.services;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();
    List<T> findByFormat(Pageable paging);
    T findById(int id);
    void add(T t);
    void edit(int id, T t);
    void delete(int id);
}
