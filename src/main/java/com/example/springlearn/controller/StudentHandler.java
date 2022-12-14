package com.example.springlearn.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.springlearn.entiry.com.Student;
import com.example.springlearn.exception.UrlGetException;
import com.example.springlearn.repository.StudentRepository;
//import  com.example.springlearn.repository.StudentRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.Collection;

/**
 * @author <lmx>
 * @since 2022/11/4 21:58
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentHandler {
  @Autowired
  private StudentRepository studentRepository;
  /**三种依赖注入方式，属性注入(@Autowired)，
   * set方法注入，构造方法注入
   * 还有一种@resoure
   */
  private final Logger log = LoggerFactory.getLogger(StudentHandler.class);


  @GetMapping("/findAll")
  @ResponseBody
  public Collection<Student> findAll() {
    return studentRepository.findAll();
  }

  @GetMapping("/findById/{id}")
  @ResponseBody
  //当方法参数名称和需要绑定的url中变量名称一致时，可以简写去掉(“id”)

  public Student findById(@PathVariable("id") Long id)  {
    //判断用户输入的id是不是long型
    log.info("接收参数:{}", JSONObject.toJSONString(id));
    Boolean res=studentRepository.getType(id);
    if(res){
      System.out.println("是long型");
    }else{
      System.out.println("不是long型");
    }


    Integer arguments=2;
    if(id>arguments){
      throw new UrlGetException(404,"该用户不存在");
    }


    return studentRepository.findById(id);
  }



  @PostMapping("/save")
  @ResponseBody

  public void save(@RequestBody Student student) {
    // 因为前端会以JSON数据返回，所以要用 @RequestBody
    studentRepository.saveOrUpdate(student);
  }

  @PutMapping("/update")
  @ResponseBody
  public void update(@RequestBody Student student) {
    studentRepository.saveOrUpdate(student);
  }

  @DeleteMapping("/deleteById/{id}")
  @ResponseBody
  public void deleteById(@PathVariable("id") Long id) {
    studentRepository.deleteById(id);
  }

  @RequestMapping("/test")
  @ResponseBody
  public String test() {
    int a = 4 / 0;
    return "test";
  }


}
