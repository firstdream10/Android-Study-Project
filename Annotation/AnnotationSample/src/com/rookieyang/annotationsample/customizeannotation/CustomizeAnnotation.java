package com.rookieyang.annotationsample.customizeannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rookieyang
 * @version 1.0.0
 * @date 17-10-19
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface CustomizeAnnotation {

    String name() default "zhangsan";

    int id() default 3;
}
