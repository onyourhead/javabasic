package edu.ncut.zzq.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * JackSon
 *
 * Created by chaogao on 15-11-16.
 */
public class JackSonUtil {
    private static final Log log = LogFactory.getLog(JackSonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectMapper notNullMapper = new ObjectMapper();
    private static final ObjectMapper dateFormatMapper = new ObjectMapper();

    static {
        notNullMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        dateFormatMapper.setDateFormat(new SimpleDateFormat(DateUtils.SECOND_FORMAT_WITH));
        dateFormatMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));  //设定北京时间，否则时间转换有误
    }

    public static String convertJson(Object object) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Convert json error!", e);
        }
        return result;
    }

    /**
     * json转clazz类型实例
     *
     * @param <T>
     * @param json
     * @param clazz 实例类型
     * @return clazz实例
     */
    public static <T> T convertJsonToBean(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.warn("convertJsonToBean failed!", e);
        }
        return null;
    }

    /**
     * Json转Map<String, Object>
     *
     * @param json
     * @return
     * @throws IOException
     */
    public static Map<String, Object> convertJsonToObjMap(String json){
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            MapType mapType = typeFactory.constructMapType(Map.class, typeFactory.constructType(String.class), typeFactory.constructType(Object.class));
            return objectMapper.readValue(json, mapType);
        } catch (Exception e){
            log.warn("convertJsonToObjMap failed!", e);
        }
        return null;
    }

    public static Map<String,Object> json2Map(String json) {
        try {
            return  objectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            log.warn("json2Map failed!", e);
        }
        return null;
    }

    public static Map<String, String> json2StrMap(String json) {
        try {
            Map<String, Object> objMap = objectMapper.readValue(json, Map.class);
            if (objMap != null) {
                return objMap.entrySet().stream().collect(Collectors.toMap(entry->entry.getKey(), entry-> entry.getValue().toString()));
            }
        } catch (IOException e) {
            log.warn("json2StrMap failed!", e);
        }
        return null;
    }

    /**
     * json字符串转List
     *
     * @param json
     * @param elementClazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonArrayToList(String json, Class<T> elementClazz) {
        if (json == null || elementClazz == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametrizedType(ArrayList.class, ArrayList.class, elementClazz);
            return objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            log.warn(String.format("jsonArrayToList failed! json: %s, elementClazz: %s", json, elementClazz), e);
        }
        return null;
    }


    /**
     * 实体类转换为map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> objToMap(Object obj) {
        return (Map<String, Object>) objectMapper.convertValue(obj, Map.class);
    }

    public static Map<String, String> objToStrMap(Object obj) {
        Map<String, Object> objMap = objectMapper.convertValue(obj, Map.class);
        if (objMap != null) {
            Map<String, String> strMap = new HashMap<String, String>(objMap.size(), 1);
            for (Map.Entry<String, Object> entry : objMap.entrySet()) {
                if (entry.getValue() != null) {
                    strMap.put(entry.getKey(), entry.getValue().toString());
                }
            }
            return strMap;
        }
        return null;
    }

    /**
     * 实体类转换为map,字段为NULl去掉
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> objToNotNullMap(Object obj) {
        return (Map<String, Object>) notNullMapper.convertValue(obj, Map.class);
    }

    public static String objToNotNullJson(Object obj) {
        try {
            return notNullMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("obj to not null json error", e);
        }
        return "";
    }

    public static <T> T objToReferenceType (Object fromValue, TypeReference<?> toValueTypeRef) {
        try {
            return objectMapper.convertValue(fromValue, toValueTypeRef);
        } catch (Exception e) {
            log.error("obj to reference type error", e);
        }
        return null;
    }

    public static <T> T jsonToReferenceType (String fromValue, TypeReference<?> toValueTypeRef) {
        try {
            return dateFormatMapper.readValue(fromValue, toValueTypeRef);
        } catch (Exception e) {
            log.error("obj to reference type error", e);
        }
        return null;
    }

    public static <T> T objToBean (Object object, Class<T> tClass) {
        try {
            return dateFormatMapper.convertValue(object, tClass);
        } catch (Exception e) {
            log.error("obj ro bean error", e);
        }
        return null;
    }

    public static String getStringFromJSONObject(String name, JSONObject json) {
        if (!json.containsKey(name)) {
            return null;
        }
        String value = json.getString(name);
        if (StringUtils.isEmpty(value) || value.equals("null")) {
            return null;
        }
        return value;
    }
}
