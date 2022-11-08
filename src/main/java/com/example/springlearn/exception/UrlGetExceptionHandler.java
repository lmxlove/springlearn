package com.example.springlearn.exception;

import com.example.springlearn.util.JsonData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <lmx>
 * @since 2022/11/7 16:27
 */
@ControllerAdvice
@Slf4j
public class UrlGetExceptionHandler {
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public JsonData handle(Exception e){
    if(e instanceof UrlGetException){
      UrlGetException urlGetException = (UrlGetException) e;
      log.error("[业务异常{}]",e);
      System.out.println("具体异常信息1 "+e);
      return JsonData.buildCodeAndMsg(urlGetException.getCode(),urlGetException.getMessage());
    }else{
      log.error("[系统异常{}]",e);
      System.out.println("具体异常信息2 "+e);

      return JsonData.buildError(e.getMessage());
    }
  }

}
