package com.example.springlearn.repository;

import com.example.springlearn.entiry.com.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 我不是大佬
 */
@Repository
public class StudentRepositoryImpl implements  StudentRepository{
  private static Map<Long,Student> studentMap;

  static{
    studentMap = new HashMap<>();
    studentMap.put(1L,new Student(1L,"张三",22));
    studentMap.put(2L,new Student(2L,"李四",23));
  }

  @Override
  public Collection<Student> findAll() {
    return studentMap.values();
  }

  @Override
  public Student findById(long id) {
    return studentMap.get(id);
  }
  @Override
  public Boolean getType(Long id){
    String type=id.getClass().toString();
    System.out.println(type);
    type=type.substring(type.lastIndexOf('.')+1,type.length());
    return "Long".equals(type);

  }

  @Override
  public void saveOrUpdate(Student student) {
    studentMap.put(student.getId(),student);
  }

  @Override
  public void deleteById(long id) {
    studentMap.remove(id);
  }


}
