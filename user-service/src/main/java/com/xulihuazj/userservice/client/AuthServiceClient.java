package com.xulihuazj.userservice.client;

import com.xulihuazj.userservice.client.hystrix.AuthServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * '
 * uaa-service获取JWT的Token
 * 熔断器
 */
@FeignClient(value = "uaa-service", fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {





}
