package com.xulihuazj.blogservice.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class UserUtils {

    private static final String AUTHORIZATION = "authorization";

    /**
     * 获取当前请求的token
     *
     * @return
     */
    public static String getCurrentToken() {
        return HttpUtils.getHeaders(HttpUtils.getHttpServletRequest()).get(AUTHORIZATION);
    }

    /**
     * 获取当前请求的用户Id
     *
     * @return
     */
    public static String getCurrentPrinciple() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 判读当前token用户是否为接口所需的参数username
     *
     * @param username
     * @return
     */
    public static boolean isMyself(String username) {
        return username.equals(UserUtils.getCurrentPrinciple());
    }

    /**
     * 获取当前请求的 Authentication
     *
     * @return
     */
    public static Authentication getCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前请求的权限信息
     *
     * @return
     */
    public static List<SimpleGrantedAuthority> getCurrentAuthorities() {
        return (List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    /**
     * 判断是否有某种权限
     *
     * @param role
     * @return
     */
    public static boolean hasRole(String role) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        boolean hasRole = false;
        List<SimpleGrantedAuthority> list = UserUtils.getCurrentAuthorities();
        for (SimpleGrantedAuthority authority : list) {
            if (role.equals(authority.getAuthority())) {
                hasRole = true;
                break;
            }
        }
        return hasRole;
    }


}
