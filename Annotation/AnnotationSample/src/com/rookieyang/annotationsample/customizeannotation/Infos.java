package com.rookieyang.annotationsample.customizeannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rookieyang
 * @version 1.0.0
 * @date 17-10-20
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Infos {

    Info[] value();
}
