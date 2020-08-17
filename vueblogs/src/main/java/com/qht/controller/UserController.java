package com.qht.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qht.common.Result;
import com.qht.entity.Blog;
import com.qht.entity.User;
import com.qht.service.UserService;
import com.qht.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author QiHaotang
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        if(currentPage == null || currentPage < 1) {
            currentPage = 1;
        }
        Page page = new Page(currentPage, 5);
        IPage pageData = userService.page(page, new QueryWrapper<User>().orderByDesc("created"));
        return Result.success(pageData);
    }


    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        User user = userService.getById(id);
        Assert.notNull(user, "该用户已删除！");
        return Result.success(user);
    }

    @RequiresAuthentication
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody User user) {
        User temp = null;
        SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword());
        if (user.getId() != null) {
            temp = userService.getById(user.getId());
            temp.setPassword(simpleHash.toString());
            //只能修改自己的账号
            Assert.isTrue(temp.getId().longValue() == ShiroUtil.getProfile().getId().longValue(),"没有权限修改，只能修改自己的账号");
        } else {
            temp = new User();
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
            temp.setUsername(user.getUsername());
            temp.setEmail(user.getEmail());
            temp.setPassword(simpleHash.toString());
            temp.setAvatar("https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg");
        }
        BeanUtil.copyProperties(user,temp,"id","status","avatar","password");
        userService.saveOrUpdate(temp);
        return Result.success(null);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable(name = "id") Long id) {
        boolean remove = userService.removeById(id);
        if(remove == false){
            Result.fail("删除失败",id);
        }
        return Result.success(null);
    }

}
