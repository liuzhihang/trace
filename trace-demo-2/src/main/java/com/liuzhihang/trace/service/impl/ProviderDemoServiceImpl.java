package com.liuzhihang.trace.service.impl;

import com.liuzhihang.trace.service.ProviderDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author liuzhihang
 * @date 2020/10/14 19:51
 */
@Slf4j
@DubboService
public class ProviderDemoServiceImpl implements ProviderDemoService {

    @Override
    public void demoTest() {

        log.info("provider 收到请求");


    }
}
