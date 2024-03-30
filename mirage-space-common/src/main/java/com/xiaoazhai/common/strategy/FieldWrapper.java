package com.xiaoazhai.common.strategy;

import com.xiaoazhai.common.util.OpUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Data
@Slf4j
@AllArgsConstructor
public class FieldWrapper<T> {

    private String op;
    private T value;

    public boolean verify(Object target) {
        if (target == null || value == null) {
            return false;
        }
        if (op == null) {
            op = "eq";
        }
        Object convertValue = value;
        try {
            if (Collection.class.isAssignableFrom(value.getClass())) {
                return OpUtils.execute(op, (Collection<? extends Comparable>) value, (Comparable) target);
            }
            if (Comparable.class.isAssignableFrom(target.getClass())) {
                return OpUtils.execute(op, (Comparable) target, (Comparable) convertValue);
            }
            return false;
        } catch (Exception e) {
            log.error("FieldWrapper verify fail {} {} {}", op, target, convertValue, e);
            return false;
        }
    }
}
