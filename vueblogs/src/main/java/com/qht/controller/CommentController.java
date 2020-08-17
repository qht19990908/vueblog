package com.qht.controller;


import com.qht.common.Result;
import com.qht.common.dto.CommentDto;
import com.qht.entity.Comment;
import com.qht.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author QiHaotang
 * @since 2020-08-13
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list/{blogId}")
    public Result list(@PathVariable(name = "blogId") Long blogId){
        List<CommentDto> list = null;
        try {
            list = commentService.list(blogId);
        } catch (Exception e) {
            Result.fail("查询失败");
        }
        return Result.success(list);
    }

    @PostMapping("/add")
    public Result add(@Validated @RequestBody Comment comment){
        commentService.save(comment);
        return Result.success(null);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable(name = "id") Long id) {
        boolean remove = commentService.removeById(id);
        if(remove == false){
            Result.fail("删除失败",id);
        }
        return Result.success(null);
    }

}
