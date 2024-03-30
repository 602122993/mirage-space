package com.xiaoazhai.common.util;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;


@Slf4j
public class OpUtils {

    public static <T> boolean eq(T t1, T t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.equals(t2);
    }

    public static <T> boolean ne(T t1, T t2) {
        return !eq(t1, t2);
    }

    public static <T extends Comparable<T>> boolean lt(T t1, T t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.compareTo(t2) < 0;
    }

    public static <T extends Comparable<T>> boolean le(T t1, T t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.compareTo(t2) <= 0;
    }

    public static <T extends Comparable<T>> boolean gt(T t1, T t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.compareTo(t2) > 0;
    }

    public static <T extends Comparable<T>> boolean ge(T t1, T t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.compareTo(t2) >= 0;
    }

    public static <T> boolean contain(T t1, Collection<T> t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return t2.contains(t1);
    }

    private static <T extends Comparable<T>> boolean noContain(T t1, Collection<T> t2) {
        if (t1 == null || t2 == null) {
            return false;
        }
        return !t2.contains(t1);
    }

    public static <T extends Comparable<T>> boolean execute(String op, T target, T curValue) {
        switch (op) {
            case "eq":
                return eq(target, curValue);
            case "ne":
                return ne(target, curValue);
            case "gt":
                return gt(target, curValue);
            case "ge":
                return ge(target, curValue);
            case "lt":
                return lt(target, curValue);
            case "le":
                return le(target, curValue);
            default:
                return false;
        }
    }

    public static <T extends Comparable<T>> boolean execute(String op, Collection<T> target, T curVal) {
        switch (op) {
            case "contain":
                return contain(curVal, target);
            case "noContain":
                return noContain(curVal, target);
            default:
                return false;
        }
    }




}
