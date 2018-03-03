package org.smart.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2018/3/3.
 */
public class StringUtil {
    public static boolean isEmpty(String string){
        if(string != null){
            string = string.trim();
        }
        return StringUtils.isEmpty(string);
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }
}
