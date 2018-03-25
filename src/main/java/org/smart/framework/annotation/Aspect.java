package org.smart.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/3/25.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
