package com.example.springlearn.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.springlearn.entiry.com.Student;
import com.example.springlearn.repository.StudentRepository;
//import  com.example.springlearn.repository.StudentRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
  private final Logger log = LoggerFactory.getLogger(StudentHandler.class);


  @GetMapping("/findAll")
  @ResponseBody
  public Collection<Student> findAll() {
    return studentRepository.findAll();
  }
//  @GetMapping("/error")
//  public  String toDo(){
//    return ";该接口被spring自带的安全框架保护，你已成功登录，可以使用接口";
//  }

  @GetMapping("/findById/{id}")
  @ResponseBody
  //当方法参数名称和需要绑定的url中变量名称一致时，可以简写去掉(“id”)

  public Student findById(@PathVariable("id") Long id) throws Exception {
    //判断用户输入的id是不是long型
    Boolean res=studentRepository.getType(id);
    if(res){
      System.out.println("是long型");
    }else{
      System.out.println("不是long型");
    }
//    public static  Boolean getType(Object o){
//      String type=o.getClass().toString();
//      System.out.println(type);
//      type=type.substring(type.lastIndexOf('.')+1,type.length());
//      if("Long".equals(type)){
//        return ture;
//      }else{
//        return false;
//      }
//    }
    log.info("接收参数:{}", JSONObject.toJSONString(id));
    Integer arguments=2;
    if(id>arguments){
      Exception RuntimeException = null;
      throw   RuntimeException;
    }
//    log.info("接收参数:{}", toJSONString(id));

    return studentRepository.findById(id);
  }

//  private String toJSONString(Long id) {
//    id.toString();
//    System.out.println(id);
//    return id.toString();
//  }

  @PostMapping("/save")
  @ResponseBody
  // 因为前端会以JSON数据返回，所以要用 @RequestBody
  public void save(@RequestBody Student student) {
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
