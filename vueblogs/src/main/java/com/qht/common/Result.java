package com.qht.common;

import com.qht.common.dto.CommentDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: vueblogs
 * @description:
 * @author: Qi Haotang
 * @create: 2020-08-11 16:51
 **/
@Data
public class Result implements Serializable {

    private int code;

    private String message;

    private Object data;

    public static Result success(Object data){
        return success(200,"操作成功",data);
    }

    public static Result success(List<CommentDto> list){
        return success(200,"查询成功",list);
    }

    public static Result success(int code,String message,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result fail(String message,Object data){
        return fail(500,message,data);
    }

    public static Result fail(String message){
        return fail(500,message,null);
    }

    public static Result fail(int code,String message,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
