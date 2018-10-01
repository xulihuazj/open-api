package com.xulihuazj.userservice.client;

import com.xulihuazj.userservice.client.hystrix.AuthServiceHystrix;
import com.xulihuazj.userservice.entity.JWT;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * '
 * uaa-service获取JWT的Token
 * 熔断器
 */
@FeignClient(value = "uaa-service", fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {


    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam(value = "grant_type") String grantType,
                 @RequestParam(value = "username") String username, @RequestParam(value = "password") String password);

}
