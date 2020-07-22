package com.xiaobian.community.enums;

import com.xiaobian.community.model.Question;
import org.springframework.web.util.pattern.PathPattern;

public enum CommentTypeEnum {

    QUESTION(1),
    CONTENT(2);


    private Integer type;

    CommentTypeEnum(Integer type){
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()){
            if (commentTypeEnum.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
