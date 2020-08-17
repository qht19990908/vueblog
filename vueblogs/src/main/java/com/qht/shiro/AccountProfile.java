package com.qht.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: vueblogs
 * @description:
 * @author: Qi Haotang
 * @create: 2020-08-12 09:46
 **/
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String userName;

    private String avatar;

    private String email;
}
