package com.transporters.truckservice.service;

import java.util.Set;


public interface AbstractService<T, I> {

    T findById(I i);

    T save(T t);

    void delete(I i);

    T update(T t, I i);

    boolean existsById(I i);

    Set<T> findAll();
}
