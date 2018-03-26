package org.smart.framework;


import org.smart.framework.helper.*;
import org.smart.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * Created by Administrator on 2018/3/26.
 */
public final class HelperLoader {

    public static void init(){
        Class<?> [] classList ={
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for(Class<?>cls:classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }

}
