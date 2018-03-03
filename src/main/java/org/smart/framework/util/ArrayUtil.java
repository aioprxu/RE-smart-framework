package org.smart.framework.util;


import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Administrator on 2018/3/3.
 */
public class ArrayUtil {

    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }

    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

}
