package com.rookieyang.runtimeannotation.customizeannotation;

import android.view.View.OnClickListener;
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
public @interface BindOnClickListener {

    /**
     *
     * @return 实现 OnClickListener 接口的类
     */
    Class<? extends OnClickListener> value();
}
