package com.rookieyang.listview.diffitem.model;

/**
 *
 * @author rookieyang
 * @date 17-10-18
 * @version 1.0.0
 */

public class ContentFirstItem extends AbstractContentItem {

    private int mImgId;
    private String mContent;

    public int getImgId() {
        return mImgId;
    }

    public void setImgId(int imgId) {
        mImgId = imgId;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
