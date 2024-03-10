package com.xiaoazhai.common.result;

import lombok.Data;

@Data
public class ActionResult {

    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public static ActionResult defaultOk(Integer code, String msg, Integer count, Object data) {
        return new ActionResult(code, msg, count, data);
    }

    public static ActionResult defaultOk(Integer count, Object data) {
        return new ActionResult(ResultCodeEnum.RC200, count, data);
    }

    public static ActionResult defaultOk(Object data) {
        return new ActionResult(ResultCodeEnum.RC200, null, data);
    }

    public static ActionResult defaultOk() {
        return new ActionResult(ResultCodeEnum.RC200);
    }

    public static ActionResult defaultFail() {
        return new ActionResult(ResultCodeEnum.RC999);
    }

    public static ActionResult defaultFail(Integer code, String msg) {
        return new ActionResult(code, msg);
    }

    public static ActionResult defaultFail(ResultCodeEnum resultCodeEnum) {
        return new ActionResult(resultCodeEnum);
    }

    public ActionResult(Integer code, String msg, Integer count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public ActionResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ActionResult(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    public ActionResult(ResultCodeEnum resultCodeEnum, Integer count, Object data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
        this.count = count;
        this.data = data;
    }

}
