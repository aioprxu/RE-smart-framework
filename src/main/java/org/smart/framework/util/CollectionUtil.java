package org.smart.framework.util;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/3.
 */
public final class CollectionUtil {

    public static boolean isEmpty(Map<Class<?>,Object> map){
        return map.isEmpty();
    }

    public static boolean isNotEmpty(Map<Class<?>,Object> map){
        return !map.isEmpty();
    }
}
