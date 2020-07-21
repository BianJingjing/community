package com.xiaobian.community.mapper;

import com.xiaobian.community.model.Question;
import com.xiaobian.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);
}