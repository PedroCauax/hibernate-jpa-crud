package com.hibernate_jpa.crud.dao;

import com.hibernate_jpa.crud.entity.Student;
import java.util.List;

public interface StudentDao {

    void save (Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
