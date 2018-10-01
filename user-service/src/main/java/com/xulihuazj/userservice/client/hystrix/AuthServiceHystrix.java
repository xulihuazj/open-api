package com.xulihuazj.userservice.client.hystrix;

import com.xulihuazj.userservice.client.AuthServiceClient;
import com.xulihuazj.userservice.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * 熔断器处理类
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {

    @Override
    public JWT getToken(String authorization, String grantType, String username, String password) {
        System.out.println("---------------opps getToken hystrix--------------------");
        return null;
    }

}
