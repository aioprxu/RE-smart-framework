package org.smart.framework.bean;

import org.smart.framework.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 * Created by Administrator on 2018/3/5.
 */
public class Param {

    private Map<String ,Object> paramMap;

    public Param (Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }


    /**
     * 根据参数名获取Long型参数值
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String ,Object> getMap(){
        return paramMap;
    }

}

