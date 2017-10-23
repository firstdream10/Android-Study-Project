package com.rookieyang.runtimeannotation;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.rookieyang.runtimeannotation.customizeannotation.BindOnClickListener;
import com.rookieyang.runtimeannotation.customizeannotation.BindView;
import java.lang.reflect.Field;

/**
 * @author rookieyang
 * @version 1.0.0
 * @date 17-10-20
 */

public class AnnotationProcessor {


    public static void process(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Activity activity;

        if (!(obj instanceof Activity)) {
            throw new RuntimeException("传入的参数不是Activity");
        }

        activity = (Activity) obj;

        for (Field field : fields) {
            try {
                View view = null;
                field.setAccessible(true );
                BindView bindView = field.getAnnotation(BindView.class);
                BindOnClickListener bindOnClickListener = field
                        .getAnnotation(BindOnClickListener.class);
                //判断是否是 View
                boolean isView = View.class.isAssignableFrom(field.getType());
                if (bindView != null && isView) {
                    view = activity.findViewById(bindView.value());
                    //设置 obj 对象当中的 field 值为 view
                    field.set(obj, view);
                }
                if (bindOnClickListener != null && isView && view != null) {
                    Class<? extends OnClickListener> listener = bindOnClickListener.value();
                    //实例化 CustomizeOnClickListener 内部类
                    OnClickListener onClickListener = listener.getConstructor(
                            obj.getClass()).newInstance(activity);
                    view.setOnClickListener(onClickListener);
                }

            } catch (Exception e) {
                Log.i(obj.getClass().getSimpleName(), e.getMessage());
            }
        }
    }
}
