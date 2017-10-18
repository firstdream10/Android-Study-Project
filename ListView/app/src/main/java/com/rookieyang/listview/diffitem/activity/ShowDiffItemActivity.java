package com.rookieyang.listview.diffitem.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.rookieyang.listview.R;
import com.rookieyang.listview.diffitem.adapter.ShowDiffAdapter;
import com.rookieyang.listview.diffitem.model.ContentFirstItem;
import com.rookieyang.listview.diffitem.model.ContentSecondItem;
import com.rookieyang.listview.diffitem.model.VIEW_TYPE;

/**
 * @author rookieyang
 * @date 17-10-18
 * @version 1.0.0
 */
public class ShowDiffItemActivity extends AppCompatActivity {

    private ListView mListView;
    private static final int COUNT = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diff_item);

        init();
    }

    private void init() {
        mListView = findViewById(R.id.listview);
        ShowDiffAdapter adapter = new ShowDiffAdapter(this, 0);
        for (int i = 0; i < COUNT; i++) {
            if (i % 2 == 0) {
                ContentFirstItem item = new ContentFirstItem();
                item.setImgId(R.mipmap.ic_launcher);
                item.setContent(getString(R.string.current_item) + (i + 1));
                item.setViewType(VIEW_TYPE.FIRST_ITEM.ordinal());
                adapter.add(item);
            } else {
                ContentSecondItem item = new ContentSecondItem();
                item.setTitle(getString(R.string.title_index) + (i + 1));
                item.setContent(getString(R.string.content_index) + (i + 1));
                item.setFooter(getString(R.string.footer_index) + (i + 1));
                item.setViewType(VIEW_TYPE.SECOND_ITEM.ordinal());
                adapter.add(item);
            }
        }
        mListView.setAdapter(adapter);
    }

    public static void actionStart(Context context, @Nullable String data) {
        Intent intent = new Intent(context, ShowDiffItemActivity.class);
        if (data != null) {
            intent.putExtra(context.getString(R.string.data), data);
        }
        context.startActivity(intent);
    }
}
