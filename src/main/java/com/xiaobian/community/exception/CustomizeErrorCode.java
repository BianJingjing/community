package com.xiaobian.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001,"你找的问题不在了，换个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYS_ERROR(2004,"服务冒烟了，稍后试试"),
    COMMENT_TYPE_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在了，换个试试"),
    CONTENT_IS_EMPTY(2007,"提交不能为空，填写回复内容"),
    READ_NOTIFICATION_FAIL(2008,"兄弟，你这是读别人的信息呢"),
    NOTIFICATION_NOT_FOUND(2009,"消息莫非不翼而飞了"),
    FILE_UPLOAD_FAIL(2010,"图片上传失败");


    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
