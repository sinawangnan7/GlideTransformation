package com.example.wangnan.glidetransformation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * RecyclerView - 视图容器
 * Created by wangnan on 2016/11/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder{

    public ImageView mImageView;
    public TextView mTextView;

    public MyViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.iv);
        mTextView = (TextView) itemView.findViewById(R.id.tv);
    }
}
