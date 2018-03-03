package org.smart.framework.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/3/3.
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * loading propertis
     */
    public static Properties loadProps(String filename){
        Properties properties = null;
        InputStream inputStream = null;
        try{
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if(inputStream == null){
                throw new FileNotFoundException(filename + "file not found");
            }
            properties = new Properties();
            properties.load(inputStream);
        }catch (IOException e){
            LOGGER.error("load propertis file failure",e);
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    LOGGER.error("close inputstream failure",e);
                }
            }
        }

        return properties;
    }


    /**
     * get propertis string
     */
    public static String getString(Properties properties ,String key){
        return getString(properties,key,"");
    }

    public static String getString(Properties properties ,String key ,String defaultValue){
        String value = defaultValue;
        if(properties.containsKey(key)){
            value = properties.getProperty(key);
        }
        return value;
    }


    /**
     * get propertis int
     */
    public static int getInt(Properties properties ,String key){
        return getInt(properties,key,0);
    }

    public static int getInt(Properties properties ,String key ,int defaultValue){
        int value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }

    /**
     * get propertis boolean
     */
    public static boolean getBoolean(Properties properties ,String key){
        return getBoolean(properties,key,false);
    }

    public static boolean getBoolean(Properties properties ,String key ,boolean defaultValue){
        boolean value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }
}
