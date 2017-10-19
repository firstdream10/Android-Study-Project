package com.rookieyang.annotation;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rookieyang
 * @date 17-10-18
 * @version 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressWarnings("unchecked")
    public void addItems(@NonNull String item) {
        List list = new ArrayList();
        list.add(item);
    }
}
