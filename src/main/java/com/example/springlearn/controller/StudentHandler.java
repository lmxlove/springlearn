package com.example.springlearn.controller;

import com.example.springlearn.entiry.com.Student;
import com.example.springlearn.exception.GlobalExceptionHandler;
import com.example.springlearn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author <lmx>
 * @since 2022/11/4 21:58
 */
@RestController
@RequestMapping("/student")
public class StudentHandler {
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/findAll")
  @ResponseBody
  public Collection<Student> findAll(){
    return studentRepository.findAll();
  }
//  @GetMapping("/error")
//  public  String toDo(){
//    return ";该接口被spring自带的安全框架保护，你已成功登录，可以使用接口";
//  }

  @GetMapping("/findById/{id}")
  @ResponseBody
  public Student findById(@PathVariable("id") Long id)throws ArithmeticException {

    return studentRepository.findById(id);
  }

  @PostMapping("/save")
  @ResponseBody
  // 因为前端会以JSON数据返回，所以要用 @RequestBody
  public void save(@RequestBody Student student){
    studentRepository.saveOrUpdate(student);
  }

  @PutMapping("/update")
  @ResponseBody
  public void update(@RequestBody Student student){
    studentRepository.saveOrUpdate(student);
  }

  @DeleteMapping("/deleteById/{id}")
  @ResponseBody
  public void deleteById(@PathVariable("id") Long id){
    studentRepository.deleteById(id);
  }
  @RequestMapping("/test")
  @ResponseBody
  public  String test(){
    int a=4/0;
    return "test";
  }


}
