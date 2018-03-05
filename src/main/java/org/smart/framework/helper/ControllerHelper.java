package org.smart.framework.helper;

import org.smart.framework.annotation.Action;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Request;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/5.
 */
public final class ControllerHelper {

    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                //获取 Conrtoller 类定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            //从Action 中获取url映射规则
                            Action action = method.getAnnotation(Action.class);
                            String map = action.value();
                            //验证URL映射规则
                            if (map.matches("\\w+:/\\w*")) {
                                String[] array = map.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 获取handler
     */
    public static Handler getHandler(String requestMethod ,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }

}
