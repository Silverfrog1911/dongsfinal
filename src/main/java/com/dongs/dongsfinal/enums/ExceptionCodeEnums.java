package com.dongs.dongsfinal.enums;

/**
 * Description:错误类型enum，主要用来返回错误码
 * Date: 2021/4/5
 */
public enum ExceptionCodeEnums {

    DATA_NOT_FOUND(1, "不存在此数据"),

    ADMIN_NOT_FOUND(2, "管理员账号或密码错误"),

    NO_TOKEN(3, "没有token"),

    NO_SIGN(4, "没有登陆"),

    WX_ERROR(5, "微信错误"),

    DATA_IS_EXIST(6, "数据已经存在"),

    WX_OK(7, "微信成功"),

    NO_DATA(8,"缺少参数"),

    ERROR_STATE(9,"订单不符合状态"),

    ERROR_MONEY(10,"支付金额与原订单金额不一致"),

    FAIL_OPERATION(11,"操作失败"),

    CURRICULUM_NUM_ZERO(12,"课程数量不足"),

    IDENTIFYCODE_ERROR(13,"验证码错误"),

    CROWDING(14,"当前太拥挤,请稍后再试"),

    INSERT_FAIL(15,"添加失败,请检查数据是否合法"),

    CANT_SELECT(16,"当前不可选此门课程"),

    USER_ALREADY_EXISTS(17,"该用户已存在!"),

    USER_TYPE_ERROR(18,"用户类型错误!"),

    PASSWORD_ERROR(19,"账号或密码错误!"),

    OPERATION_ERROR(20,"非法操作!"),

    VULNERABILITY_ATTACK(21,"检测到漏洞攻击!"),

    MESSAGE_LOADING(22,"请一分钟后再点击发送!"),

    PHONE_NOT_RESIGN(23,"该号码未注册!"),

    PHONE_SEND_OVERTIMES(24,"手机号码已达到当天发送次数,请用账号密码登录!"),

    PHONE_RESIGNED(25,"该号码已注册!"),

    ;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    ExceptionCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
