package com.qht.mapper;

import com.qht.common.dto.CommentDto;
import com.qht.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author QiHaotang
 * @since 2020-08-13
 */
public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentDto> list(Long blogId);
}
