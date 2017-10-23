package com.rookieyang.compilertimeannotation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.rookieyang.annotations.HelloWorld;
import com.rookieyang.compilertimeannotation.R;
import java.lang.reflect.Method;

/**
 *
 * @author rookieyang
 * @date 17-10-22
 * @version 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    @HelloWorld
    private Button mHelloBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloBtn = findViewById(R.id.hello_world);
        mHelloBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    private void show() {
        try {
            //获得生成的类的 Class 对象
            Class<?> helloClass = Class.forName(getPackageName() + "."
                    + getClass().getSimpleName() + "_HelloWorld");
            //利用反射取得 show 方法，然后执行对应的方法即可
            Method showMethod = helloClass.getMethod("show", Context.class);
            showMethod.invoke(this, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
