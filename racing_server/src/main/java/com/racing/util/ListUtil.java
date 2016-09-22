package com.racing.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUtil {
  /**
   * 获取list的第一个值
   * 
   * @param list
   * @return
   */
  public static <T> T getFirstItemFromList(List<T> list) {
    T t = null;
    if (list != null && list.size() > 0) {
      t = list.get(0);
    }
    return t;
  }

  /**
   * 默认处理List
   * 
   * @param list
   * @return
   */
  public static <T> List<T> getDefaultList(List<T> list) {
    if (list != null && list.size() > 0) {
      return list;
    } else {
      return null;
    }
  }

  public static <T> boolean isEmpty(List<T> list) {
    if (list != null && list.size() > 0) {
      return false;
    }
    return true;
  }

  /**
   * 截取list 用于程序分页使用
   * 
   * @param list
   * @param index 开始位置（从0开始包含index）
   * @param length 截取的长度
   * @return
   */
  public static <T> List<T> subList(List<T> list, int index, int length) {
    List<T> sub = null;
    if (list == null || list.size() == 0) {
      return null;
    } else {
      int size = list.size();
      if (index > size) {// 开始位置大于list的长度
        return null;
      } else if (index + length >= size) {// 取出越界时只去到最后一个
        sub = list.subList(index, size);
      } else {
        sub = list.subList(index, index + length);
      }
    }
    return sub;
  }

  /**
   * 对List对象进行去重操作
   * 
   * @param list
   * @return
   */
  public static <T> List<T> duplicateRemoval(List<T> list) {
    List<T> resultTempList = new ArrayList<T>();
    for (T obj : list) {
      if (!resultTempList.contains(obj)) {
        resultTempList.add(obj);
      }
    }

    return resultTempList;
  }

  /**
   * 对map中的key字典升序排序排序，然后根据key拼接value
   * 
   * @param dataMap
   * @return
   */
  public static String sortMapParameterValueStr(Map<String, String> dataMap) {
    Collection<String> keyset = dataMap.keySet();
    List<String> list = new ArrayList<String>(keyset);

    // 对key键值按字典升序排序
    Collections.sort(list);

    String parameters = "";
    for (String key : list) {
      parameters = parameters + dataMap.get(key);
    }
    return parameters;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static Map<String, String> formatObjMapToStringMap(Map<String, Object> dataMap) {
    Map<String, String> returnMap = new HashMap<String, String>();
    for (String key : dataMap.keySet()) {
      Object value = dataMap.get(key);
      if (value instanceof String) {
        returnMap.put(key, (String) value);
      } else if (value instanceof List) {
        String valueStr = "";
        for (Object element : (List) value) {
          valueStr = valueStr + element.toString();
        }
        returnMap.put(key, valueStr);
      } else if (value instanceof Map) {
        Map<String, String> valueMap = formatObjMapToStringMap((Map<String, Object>) value);
        returnMap.putAll(valueMap);
      } else {
        returnMap.put(key, value.toString());
      }
    }
    return returnMap;
  }
}
