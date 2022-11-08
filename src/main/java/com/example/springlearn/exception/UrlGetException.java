package com.example.springlearn.exception;


import lombok.Data;
import com.example.springlearn.enums.UrlGetCodeEnum;



/**
 * @author <lmx>
 * @since 2022/11/7 16:30
 */
@Data
public class UrlGetException extends  RuntimeException{
  private  int code;
  private  String message;
  public  UrlGetException(int code,String message){
    super(message);
    this.code=code;
    this.message=message;

  }
  public  UrlGetException(UrlGetCodeEnum urlGetCodeEnum){
    super(urlGetCodeEnum.getMessage());
    this.code= urlGetCodeEnum.getCode();
    this.message= urlGetCodeEnum.getMessage();
  }



}
