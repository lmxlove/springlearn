package com.example.springlearn.exception;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
  private  final Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);
  @ExceptionHandler(value=Exception.class)
  public String handleException(Exception e) {
    Throwable ex=e;
    if (e instanceof ArithmeticException) {
      log.error("default Exception",e);
      return "数据异常";
    }
    if(e instanceof RuntimeException){

      log.error("该用户不存在",e);
      return "该用户不存在";
    }


    return null;
  }

}
