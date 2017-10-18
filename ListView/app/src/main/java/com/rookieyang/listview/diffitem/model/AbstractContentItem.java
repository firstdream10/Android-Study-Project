package com.rookieyang.listview.diffitem.model;

/**
 * Description:
 * 所有 Item 的父类
 * @author rookieyang
 * @date 17-10-18
 * @version 1.0.0
 */

public abstract class AbstractContentItem {

    protected int mViewType;

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }
}
