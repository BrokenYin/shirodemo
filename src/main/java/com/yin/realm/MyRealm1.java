package com.yin.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 自定义Realm实现
 *
 * */
public class MyRealm1 implements Realm {

    /**
     * 返回一个唯一的Realm名字
     * */
    public String getName() {
        return "myRealm1";
    }

    /**
     * 判断此Realm是否支持此Token
     * */
    public boolean supports(AuthenticationToken token) {
        // 仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 根据Token获取认证信息
     * */
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String( (char[])token.getCredentials() );

        if ( !"zhang".equals(username) ){
            throw new UnknownAccountException();
        }
        if ( !"123".equals(password) ){
            throw new IncorrectCredentialsException();
        }
        System.out.println("zzzzzzzzzzzzzzzzzz");
        // 如果身份认证成功，返回一个AuthenticationInfo实现
        return new SimpleAuthenticationInfo(username, password, getName() );
    }
}
