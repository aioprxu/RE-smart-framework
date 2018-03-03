package org.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by Administrator on 2018/3/3.
 */
public class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * getClassLoader
     */
    public static ClassLoader getClassLoader (){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className,boolean isInitialized){
        Class<?> cls;
        try{
            cls = Class.forName(className,isInitialized,getClassLoader());
        }catch (ClassNotFoundException e){
            LOGGER.error("load class failure",e);
            throw new RuntimeException(e);
        }
        return cls;
    }


    /**
     * get all class from package by name
     */
    public static Set<Class<?>> getClassSet(String packageName){
        //TODO
        return null;
    }
}
