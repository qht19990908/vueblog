package com.qht.service;

import com.qht.common.dto.CommentDto;
import com.qht.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author QiHaotang
 * @since 2020-08-13
 */
public interface CommentService extends IService<Comment> {

    List<CommentDto> list(Long bolgId);
}
