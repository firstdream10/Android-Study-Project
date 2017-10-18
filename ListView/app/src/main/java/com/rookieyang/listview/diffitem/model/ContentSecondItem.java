package com.rookieyang.listview.diffitem.model;

import android.support.annotation.NonNull;

/**
 *
 * @author rookieyang
 * @date 17-10-18
 * @version 1.0.0
 */

public class ContentSecondItem extends AbstractContentItem {

    private String mTitle;
    private String mContent;
    private String mFooter;

    @NonNull
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getFooter() {
        return mFooter;
    }

    public void setFooter(String footer) {
        mFooter = footer;
    }
}
