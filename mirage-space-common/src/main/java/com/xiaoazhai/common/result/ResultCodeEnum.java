package com.xiaoazhai.common.result;

public enum ResultCodeEnum {
    /**
     * 操作成功
     */
    RC200(200, "操作成功"),
    /**
     * 未授权
     */
    RC401(401, "用户未授权"),
    /**
     * 请求被禁止
     */
    RC403(403, "请求被禁止"),
    /**
     * 服务异常
     */
    RC500(500, "服务器异常，请联系管理员"),
    /**
     * 操作失败
     */
    RC999(999, "操作失败"),

    RC1001(1001, "用户名密码错误"),
    RC1002(1002, "未授权的资源"),
    RC1003(1003, "未授权的资源"),
    RC1004(1004, "缺少请求参数异常"),
    RC1005(1005, "缺少请求体参数异常"),
    RC1006(1006, "参数绑定异常"),
    RC1007(1007, "方法参数无效异常");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
