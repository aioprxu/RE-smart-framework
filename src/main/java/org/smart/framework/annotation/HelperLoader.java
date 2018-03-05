package org.smart.framework.annotation;

import org.smart.framework.helper.BeanHelper;
import org.smart.framework.helper.ClassHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.helper.IocHelper;
import org.smart.framework.util.ClassUtil;

/**
 * 加载相应的helper类
 * Created by Administrator on 2018/3/5.
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }

}
