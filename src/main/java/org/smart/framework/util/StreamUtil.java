package org.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 流操作工具类
 * Created by Administrator on 2018/3/5.
 */
public final class StreamUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     */
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine())!= null){
                sb.append(line);
            }
        } catch (IOException e) {
            LOGGER.error("get String failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
