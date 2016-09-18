package com.racing.util;


import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import jodd.util.StringUtil;

/**
 * Json工具类
 * 
 * @author leon
 *
 */
public class JsonUtils {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

  /**
   * java实体对象转换成json字符串 </br>
   * 默认对象中出现值为null时 隐藏json中的key
   * 
   * @param obj
   * @return
   */
  public static String toJsonNotNullKey(Object obj) {
    return JsonUtils.toJson(obj, true);
  }

  /**
   * java实体对象转换成json字符串 </br>
   * 默认对象中出现值为null时 显示json中的key,其值为null
   * 
   * @param obj
   * @return
   */
  public static String toJsonHasNullKey(Object obj) {
    return JsonUtils.toJson(obj, false);
  }

  /**
   * java实体对象转换成json字符串
   * 
   * @param obj
   * @param isHideNullKey 是否隐藏值为null的Key
   * @return
   */
  private static String toJson(Object obj, boolean isHideNullKey) {
    ObjectMapper objMaper = new ObjectMapper();
    if (isHideNullKey) {
      objMaper.setSerializationInclusion(Include.NON_NULL);
    }
    Writer writer = new StringWriter();
    String json = null;
    try {
      objMaper.writeValue(writer, obj);
      json = writer.toString();
      writer.close();
    } catch (IOException e) {
      // 错误处理
      logger.error("JsonUtils transformation obj to string has error!" + e);
    }
    return json;
  }

  /**
   * json字符串转换为对应的java实体对象
   * 
   * @param jsonStr
   * @param objClass
   * @return
   */
  public static <T> T toObj(String jsonStr, Class<T> objClass) {
    T obj = null;
    try {
      if (StringUtil.isEmpty(jsonStr)) {
        obj = objClass.newInstance();
      } else {
        ObjectMapper objMaper = new ObjectMapper();
        obj = objMaper.readValue(jsonStr, objClass);
      }
    } catch (IOException | InstantiationException | IllegalAccessException e) {
      // 处理异常
      logger.error("JsonUtils transformation string to obj has Eroor!" + e);
    }
    return obj;
  }

  public static <T> List<T> toObjList(String jsonStr, Class<T> objClass) {
    ObjectMapper mapper = new ObjectMapper();
    List<T> list = null;
    try {
      list = mapper.readValue(jsonStr, mapper.getTypeFactory().constructParametrizedType(ArrayList.class, List.class, objClass));
    } catch (IOException e) {
      // 处理异常
      logger.error("JsonUtils transformation string to objList has Eroor!" + e);
    }
    return list;
  }

}
