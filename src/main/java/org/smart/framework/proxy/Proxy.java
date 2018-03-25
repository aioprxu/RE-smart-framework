package org.smart.framework.proxy;

/**
 * 代理接口
 * Created by Administrator on 2018/3/25.
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
