package com.example.springlearn.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
  private  final Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);
  @ExceptionHandler(Exception.class)
  public String handleException(Exception e) {
    if (e instanceof ArithmeticException) {
      log.error("default Exception",e);
      return "数据异常";
    }
    if(e instanceof Exception){
      log.error("default Exception",e);
      return "服务器内部错误";
    }
    return null;
  }
}
