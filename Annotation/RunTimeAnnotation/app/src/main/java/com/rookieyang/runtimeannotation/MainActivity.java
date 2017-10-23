package com.rookieyang.runtimeannotation;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.rookieyang.runtimeannotation.customizeannotation.BindOnClickListener;
import com.rookieyang.runtimeannotation.customizeannotation.BindView;

/**
 * @author rookieyang
 * @version 1.0.0
 * @date 17-10-18
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hello_world)
    @BindOnClickListener(CustomizeOnClickListener.class)
    private Button mHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnnotationProcessor.process(this);
    }

    class CustomizeOnClickListener implements OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, R.string.hello_world,
                    Toast.LENGTH_SHORT).show();
        }
    }

}
