package com.xulihuazj.blogservice.service.impl;

import com.xulihuazj.blogservice.config.RabbitConfig;
import com.xulihuazj.blogservice.data.SysLogDO;
import com.xulihuazj.blogservice.service.LoggerService;
import com.xulihuazj.common.utils.JSONHelper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void saveLog(SysLogDO sysLog) {
        this.amqpTemplate.convertAndSend(RabbitConfig.queueName,
                JSONHelper.toJoson(sysLog));
    }
}
