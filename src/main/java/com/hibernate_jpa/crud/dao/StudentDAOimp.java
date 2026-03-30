package com.hibernate_jpa.crud.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate_jpa.crud.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOimp implements StudentDao {

    private EntityManager entityManager;

public StudentDAOimp(EntityManager entityManager) {
    this.entityManager = entityManager;
}


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }


    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }
}
