package com.liuzhihang.trace.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author liuzhihang
 * @date 2020/10/14 20:36
 */
@Activate(group = {"provider", "consumer"})
public class TraceIdFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {


        RpcContext rpcContext = RpcContext.getContext();


        String traceId;

        if (rpcContext.isConsumerSide()) {

            traceId = MDC.get("traceId");

            if (traceId == null) {
                traceId = UUID.randomUUID().toString();
            }

            rpcContext.setAttachment("traceId", traceId);

        }

        if (rpcContext.isProviderSide()) {
            traceId = rpcContext.getAttachment("traceId");
            MDC.put("traceId", traceId);
        }

        return invoker.invoke(invocation);
    }
}
