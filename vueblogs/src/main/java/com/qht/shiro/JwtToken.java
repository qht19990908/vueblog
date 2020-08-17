package com.qht.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @program: vueblogs
 * @description:
 * @author: Qi Haotang
 * @create: 2020-08-11 17:32
 **/
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt){
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
