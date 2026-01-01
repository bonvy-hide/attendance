package com.gc.attendance.common.result;

import lombok.Getter;

/**
 * 响应状态码枚举
 *
 * @author attendance
 * @since 1.0.0
 */
@Getter
public enum ResultCode {
    /**
     * 统一状态码枚举
     * code 类型：String
     * 格式约定：
     * - 成功：200
     * - 客户端错误：4xx
     * - 服务端错误：5xx
     * - 业务错误：x开头（如：10xx, 11xx等）
     */

    // ==================== 成功 ====================
    SUCCESS("200", "操作成功"),

    // ==================== 客户端错误 4xx ====================
    FAIL("400", "操作失败"),
    BAD_REQUEST("400", "请求参数错误"),
    UNAUTHORIZED("401", "未授权"),
    FORBIDDEN("403", "禁止访问"),
    NOT_FOUND("404", "资源不存在"),
    METHOD_NOT_ALLOWED("405", "请求方法不允许"),
    REQUEST_TIMEOUT("408", "请求超时"),
    CONFLICT("409", "资源冲突"),
    GONE("410", "资源已删除"),
    PAYLOAD_TOO_LARGE("413", "请求体过大"),
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型"),
    TOO_MANY_REQUESTS("429", "请求过于频繁"),

    // ==================== 服务端错误 5xx ====================
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    NOT_IMPLEMENTED("501", "功能未实现"),
    BAD_GATEWAY("502", "网关错误"),
    SERVICE_UNAVAILABLE("503", "服务不可用"),
    GATEWAY_TIMEOUT("504", "网关超时"),

    // ==================== 业务错误 1xxx ====================
    // 认证相关 10xx
    TOKEN_INVALID("1001", "Token无效"),
    TOKEN_EXPIRED("1002", "Token已过期"),
    LOGIN_FAILED("1003", "登录失败"),
    ACCOUNT_DISABLED("1004", "账号已禁用"),
    ACCOUNT_LOCKED("1005", "账号已锁定"),
    PASSWORD_ERROR("1006", "密码错误"),

    // 参数校验 11xx
    PARAM_ERROR("1100", "参数校验失败"),
    PARAM_MISSING("1101", "缺少必要参数"),
    PARAM_TYPE_ERROR("1102", "参数类型错误"),
    PARAM_RANGE_ERROR("1103", "参数范围错误"),

    // 数据相关 12xx
    DATA_NOT_FOUND("1200", "数据不存在"),
    DATA_ALREADY_EXISTS("1201", "数据已存在"),
    DATA_ERROR("1202", "数据错误"),
    DATA_SAVE_ERROR("1203", "数据保存失败"),
    DATA_UPDATE_ERROR("1204", "数据更新失败"),
    DATA_DELETE_ERROR("1205", "数据删除失败"),

    // 考勤业务相关 20xx
    ATTENDANCE_NOT_FOUND("2001", "考勤记录不存在"),
    ATTENDANCE_ALREADY_CHECKED_IN("2002", "已打卡，无需重复打卡"),
    ATTENDANCE_NOT_IN_RANGE("2003", "不在打卡范围内"),
    ATTENDANCE_NOT_IN_TIME("2004", "不在打卡时间内"),
    ATTENDANCE_RULE_NOT_FOUND("2005", "考勤规则不存在"),
    ATTENDANCE_GROUP_NOT_FOUND("2006", "考勤组不存在"),
    ATTENDANCE_SCHEDULE_NOT_FOUND("2007", "排班不存在"),
    ATTENDANCE_LEAVE_CONFLICT("2008", "请假时间冲突"),
    ATTENDANCE_OVERTIME_CONFLICT("2009", "加班时间冲突"),
    ATTENDANCE_APPEAL_EXISTS("2010", "申诉记录已存在"),
    ATTENDANCE_APPEAL_EXPIRED("2011", "申诉已过期"),

    // 文件相关 30xx
    FILE_NOT_FOUND("3001", "文件不存在"),
    FILE_UPLOAD_ERROR("3002", "文件上传失败"),
    FILE_DOWNLOAD_ERROR("3003", "文件下载失败"),
    FILE_TYPE_NOT_ALLOWED("3004", "文件类型不允许"),
    FILE_SIZE_EXCEEDED("3005", "文件大小超限"),

    // 第三方服务 40xx
    THIRD_PARTY_ERROR("4001", "第三方服务异常"),
    SMS_SEND_ERROR("4002", "短信发送失败"),
    EMAIL_SEND_ERROR("4003", "邮件发送失败"),
    PUSH_SEND_ERROR("4004", "推送发送失败");

    /**
     * 状态码
     */
    private final String code;

    /**
     * 消息
     */
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

