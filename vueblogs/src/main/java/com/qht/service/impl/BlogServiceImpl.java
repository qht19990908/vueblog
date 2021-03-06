package com.qht.service.impl;

import com.qht.entity.Blog;
import com.qht.mapper.BlogMapper;
import com.qht.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author QiHaotang
 * @since 2020-08-11
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
