package com.xiaoazhai.common.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson2.JSONObject;
import com.xiaoazhai.common.annotations.JsonDetail;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class JsonDetailFormatUtil {


    public static String toJson(Object object) {
        Field[] fields = ReflectUtil.getFields(object.getClass());
        List<Field> needFormatList = Arrays.stream(fields)
                .filter(field -> field.getAnnotation(JsonDetail.class) != null)
                .toList();
        if (CollectionUtil.isEmpty(needFormatList)) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        needFormatList.forEach(field -> jsonObject.put(field.getName(), ReflectUtil.getFieldValue(object, field)));
        return jsonObject.toJSONString();
    }

    public static void fromJson(Object obj, String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Field[] fields = ReflectUtil.getFields(obj.getClass());
        List<Field> needFormatList = Arrays.stream(fields)
                .filter(field -> field.getAnnotation(JsonDetail.class) != null)
                .toList();
        if (CollectionUtil.isNotEmpty(needFormatList)) {
            needFormatList.forEach(field -> ReflectUtil.setFieldValue(obj, field, jsonObject.get(field.getName())));
        }
    }
}
