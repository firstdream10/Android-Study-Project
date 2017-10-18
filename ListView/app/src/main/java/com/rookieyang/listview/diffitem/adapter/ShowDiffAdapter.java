package com.rookieyang.listview.diffitem.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.rookieyang.listview.R;
import com.rookieyang.listview.diffitem.model.AbstractContentItem;
import com.rookieyang.listview.diffitem.model.ContentFirstItem;
import com.rookieyang.listview.diffitem.model.ContentSecondItem;
import com.rookieyang.listview.diffitem.model.VIEW_TYPE;

/**
 * Description:
 * ListView 的适配器
 *
 * @author rookieyang
 * @version 1.0
 * @date 17-10-18
 */
public class ShowDiffAdapter extends ArrayAdapter<AbstractContentItem> {

    public ShowDiffAdapter(@NonNull Context context,
            int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        AbstractContentItem item = getItem(position);
        if (convertView == null) {
            view = onBindViewHolder(item, parent);
        } else {
            boolean result = onSetViewHolder(item, convertView);
            if (!result) {
                view = onBindViewHolder(item, parent);
            } else {
                view = convertView;
            }
        }
        return view;
    }


    private View onBindViewHolder(AbstractContentItem item, ViewGroup parent) {
        View view = null;
        int viewType = item.getViewType();
        ContentFirstItem contentFirstItem;
        ContentSecondItem contentSecondItem;
        FirstViewHolder firstViewHolder;
        SecondViewHolder secondViewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE.FIRST_ITEM.ordinal()) {
            contentFirstItem = (ContentFirstItem) item;
            view = layoutInflater.inflate(R.layout.first_item, parent, false);
            firstViewHolder = new FirstViewHolder(view);
            firstViewHolder.mImageView.setImageResource(contentFirstItem.getImgId());
            firstViewHolder.mContentView.setText(contentFirstItem.getContent());
            view.setTag(firstViewHolder);
        } else if (viewType == VIEW_TYPE.SECOND_ITEM.ordinal()) {
            contentSecondItem = (ContentSecondItem) item;
            view = layoutInflater.inflate(R.layout.second_item, parent, false);
            secondViewHolder = new SecondViewHolder(view);
            secondViewHolder.mTitleView.setText(contentSecondItem.getTitle());
            secondViewHolder.mContentView.setText(contentSecondItem.getContent());
            secondViewHolder.mFooterView.setText(contentSecondItem.getFooter());
            view.setTag(secondViewHolder);
        }
        return view;
    }

    private boolean onSetViewHolder(AbstractContentItem item, View view) {
        FirstViewHolder firstViewHolder;
        SecondViewHolder secondViewHolder;
        ContentFirstItem contentFirstItem;
        ContentSecondItem contentSecondItem;
        Object viewHolder = view.getTag();
        if (item.getViewType() == VIEW_TYPE.FIRST_ITEM.ordinal()) {
            if (viewHolder instanceof FirstViewHolder) {
                firstViewHolder = (FirstViewHolder) viewHolder;
                contentFirstItem = (ContentFirstItem) item;
                firstViewHolder.mImageView.setImageResource(contentFirstItem.getImgId());
                firstViewHolder.mContentView.setText(contentFirstItem.getContent());
                return true;
            }
        } else if (item.getViewType() == VIEW_TYPE.SECOND_ITEM.ordinal()) {
            if (viewHolder instanceof SecondViewHolder) {
                secondViewHolder = (SecondViewHolder) viewHolder;
                contentSecondItem = (ContentSecondItem) item;
                secondViewHolder.mTitleView.setText(contentSecondItem.getTitle());
                secondViewHolder.mContentView.setText(contentSecondItem.getContent());
                secondViewHolder.mFooterView.setText(contentSecondItem.getFooter());
                return true;
            }
        }
        return false;
    }

    private static class FirstViewHolder {

        private ImageView mImageView;
        private TextView mContentView;

        FirstViewHolder(View view) {
            mImageView = view.findViewById(R.id.image);
            mContentView = view.findViewById(R.id.first_content);
        }
    }

    private static class SecondViewHolder {

        private TextView mTitleView;
        private TextView mContentView;
        private TextView mFooterView;

        SecondViewHolder(View view) {
            mTitleView = view.findViewById(R.id.title);
            mContentView = view.findViewById(R.id.second_content);
            mFooterView = view.findViewById(R.id.footer);
        }
    }
}
