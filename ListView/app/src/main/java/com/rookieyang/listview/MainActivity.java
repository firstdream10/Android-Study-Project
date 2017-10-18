package com.rookieyang.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.rookieyang.listview.diffitem.activity.ShowDiffItemActivity;

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

        init();
    }

    private void init() {
        Button showDiffItemBtn = findViewById(R.id.show_diff_item);
        showDiffItemBtn.setOnClickListener((v) ->
                ShowDiffItemActivity.actionStart(this, null));
    }
}
