package com.qht.service.impl;

import com.qht.common.dto.CommentDto;
import com.qht.entity.Comment;
import com.qht.mapper.CommentMapper;
import com.qht.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QiHaotang
 * @since 2020-08-13
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDto> list(Long bolgId) {
        List<CommentDto> list = commentMapper.list(bolgId);
        return list;
    }
}
