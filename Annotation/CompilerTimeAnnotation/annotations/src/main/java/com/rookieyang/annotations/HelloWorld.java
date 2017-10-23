package com.rookieyang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author rookieyang
 * @date 17-10-22
 * @version 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface HelloWorld {
}
