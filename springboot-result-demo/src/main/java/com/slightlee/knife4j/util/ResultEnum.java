package com.slightlee.knife4j.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    // 2xx - 成功
    SUCCESS(200, "操作成功"),


    // 3xx - 重定向


    // 4xx - 请求错误
    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403,"服务器拒绝请求"),
    NOT_FOUND(404,"未找到"),
    METHOD_NOT_ALLOWED(405,"客户端请求中的方法被禁止"),


    // 5xx - 服务器错误
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),
    NOT_IMPLEMENTED(501,"尚未实施"),
    BAD_GATEWAY(502,"错误网关"),
    SERVICE_UNAVAILABLE(503,"服务不可用"),
    GATEWAY_TIME_OUT(504,"网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505,"HTTP 版本不受支持"),


    // 操作失败
    FAILED(9001, "操作失败"),


    // 业务

    //--- 权限验证返回码 1xxx ---
    TOKEN_INVALID(1001,"凭证无效"),
    PLAYAUTH_FAIL(1002,"获取凭证失败"),
    ACCOUNT_PASSWORD_IS_NULL(1003,"账号或密码为空"),
    ACCOUNT_NOT_EXIST(1004,"账号不存在"),
    PASSWORD_CHECK_FAIL(1005,"密码校验失败"),
    LOGIN_FAIL(1006,"登录失败"),
    ACCOUNT_DISABLE(1007,"账号被禁用"),
    UN_AUTHORISE(1008,"权限不足"),
    UN_AUTHENTICATED(1009,"您还未登录"),
    UN_AUTHORIZED(1010, "暂未登录或token已经过期"),


    //---操作数据返回码  3xxx ----
    ADD_FAIL(3001,"添加失败"),
    UPDATE_FAIL(3002,"修改失败"),
    DELETE_FAIL(3003,"删除失败"),
    SEND_FAIL(3004,"发送失败"),
    QUERY_FAIL(3005,"查询失败"),


    // ----参数-----  4xxx ---
    ILLEGAL_PARAMETER(4001,"参数不合法"),
    OLD_PASSWORD_ERROR(4002, "旧密码错误"),
    FILE_FORMAT_IS_ERROR(4003,"请上传指定格式的文件"),


    // ---- 计算----  5xxx ---
    DIVIDED_IS_ERROR(5001,"除法计算出现错误");

    /**
     * 错误类型码
     */
    public int code;

    /**
     * 错误类型描述信息
     */
    public String msg;

}
