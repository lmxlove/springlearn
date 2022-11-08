package com.example.springlearn.util;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.example.springlearn.enums.UrlGetCodeEnum;

/**
 * @author <lmx>
 * @since 2022/11/7 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {
  private Integer code;
  /**
   * 数据
   */
  private Object data;
  /**
   * 描述
   */
  private String msg;
  /**
   * 成功，传入数据
   * @return
   */
  public static JsonData buildSuccess() {
    return new JsonData(0, null, null);
  }
  /**
   *  成功，传入数据
   * @param data
   * @return
   */
  public static JsonData buildSuccess(Object data) {
    return new JsonData(0, data, null);
  }
  /**
   * 失败，传入描述信息
   * @param msg
   * @return
   */
  public static JsonData buildError(String msg) {
    return new JsonData(-1, null, msg);
  }

  /**
   * 自定义状态码和错误信息
   * @param code
   * @param msg
   * @return
   */
  public static JsonData buildCodeAndMsg(int code, String msg) {
    return new JsonData(code, null, msg);
  }
  /**
   * 传入枚举，返回信息
   * @param codeEnum
   * @return
   */
  public static JsonData buildResult(UrlGetCodeEnum codeEnum) {
    return JsonData.buildCodeAndMsg(codeEnum.getCode(), codeEnum.getMessage());
  }
}
