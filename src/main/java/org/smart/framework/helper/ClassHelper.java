package org.smart.framework.helper;

import org.smart.framework.ConfigConstant;
import org.smart.framework.annotation.Controller;
import org.smart.framework.annotation.Service;
import org.smart.framework.proxy.AspectProxy;
import org.smart.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/3.
 */
public final class ClassHelper {


    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }


    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }

    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : classSet){
            if(superClass.isAssignableFrom(cls)&&!superClass.equals(cls)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotation) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?>cls:classSet){
            if(cls.isAnnotationPresent(annotation)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
