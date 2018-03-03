package org.smart.framework.util;

/**
 * Created by Administrator on 2018/3/3.
 */
public final class CastUtil {


    /**
     * tostring
     */
    public static String castString(Object object){
        return castString(object,"");
    }

    public static String castString(Object object,String defaultValue){
        return object !=null ? String.valueOf(object) : defaultValue;
    }


    /**
     *  todouble
     */
    public static double castDouble(Object object){
        return castDouble(object,0);
    }

    public static double castDouble(Object object,double defaultValue){
        double value = defaultValue;
        if(object !=null){
            String stringValue = castString(object);
            if(StringUtil.isNotEmpty(stringValue)){
                try{
                    value = Double.parseDouble(stringValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     *  tolong
     */
    public static long castLong(Object object){
        return castLong(object,0);
    }

    public static long castLong(Object object,long defaultValue){
        long value = defaultValue;
        if(object !=null){
            String stringValue = castString(object);
            if(StringUtil.isNotEmpty(stringValue)){
                try{
                    value = Long.parseLong(stringValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }


    /**
     *  toint
     */
    public static int castInt(Object object){
        return castInt(object,0);
    }

    public static int castInt(Object object,int defaultValue){
        int value = defaultValue;
        if(object !=null){
            String stringValue = castString(object);
            if(StringUtil.isNotEmpty(stringValue)){
                try{
                    value = Integer.parseInt(stringValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     *  toboolean
     */
    public static boolean castBoolean(Object object){
        return castBoolean(object,false);
    }

    public static boolean castBoolean(Object object,boolean defaultValue){
        boolean value = defaultValue;
        if(object !=null){
            String stringValue = castString(object);
            if(StringUtil.isNotEmpty(stringValue)){
                try{
                    value = Boolean.parseBoolean(stringValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }
}
