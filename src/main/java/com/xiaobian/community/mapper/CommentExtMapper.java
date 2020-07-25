package com.xiaobian.community.mapper;

import com.xiaobian.community.model.Comment;
import com.xiaobian.community.model.CommentExample;
import com.xiaobian.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}