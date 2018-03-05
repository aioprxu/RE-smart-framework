package org.smart.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装Action信息
 * Created by Administrator on 2018/3/5.
 */
public class Handler {

    /**
     * Controller class
     */
    private Class<?> controllerClass;

    private Method actionMethod;

    public Handler (Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
