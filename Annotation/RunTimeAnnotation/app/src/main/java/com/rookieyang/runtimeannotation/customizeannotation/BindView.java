package com.rookieyang.runtimeannotation.customizeannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rookieyang
 * @version 1.0.0
 * @date 17-10-20
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {

    /**
     *
     * @return View 的 Id
     */
    int value();
}
