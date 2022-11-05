package com.example.springlearn.repository;

import com.example.springlearn.entiry.com.Student;

import java.util.Collection;

/**
 * @author <lmx>
 * @since 2022/11/4 22:01
 */
public interface StudentRepository {
  Collection<Student> findAll();
  Student findById(long id);
  void saveOrUpdate(Student student);
  void deleteById(long id);

}
