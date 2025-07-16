package com.dianxing.service;

import com.dianxing.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    void delete(Integer id);

    void add(Student s);

    Student getById(Integer id);

    void update(Student s);

    List<Student> search(String studentId, String name);
}
