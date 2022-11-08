package com.example.springlearn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 我不是大佬
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringlearnApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringlearnApplication.class, args);
  }
// run(类名.class,arg)

}
