package com.example.wangnan.glidetransformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * RecyclerView适配器
 * Created by wangnan on 2016/11/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

    /**
     * 默认图片(测试使用的图片URL地址)
     */
    private static final String IMAGE_URL = "http://upload-images.jianshu.io/upload_images/2693519-cd20ad83a38de321.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240";

    private Context mContext;
    private List<String> mDatas;

    public RecyclerViewAdapter(@NonNull Context context, @Nullable List<String> datas){
        mContext = context;
        mDatas = datas == null ? new ArrayList<String>() : datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if(mDatas.get(position) != null){
            // 设置文本
            holder.mTextView.setText("图片转换类型 : " + mDatas.get(position));
            // 设置图片
            setImageView(holder.mImageView, mDatas.get(position));
        }

    }

    /**
     * 设置图片
     * @param imageView
     * @param type
     */
    private void setImageView(ImageView imageView, String type) {
        Transformation<Bitmap> bitmapTransformation = null;
        switch (type){
            case "CropTransformation":
                bitmapTransformation = new CropTransformation(mContext);
                break;
            case "CropCircleTransformation":
                bitmapTransformation = new CropCircleTransformation(mContext);
                break;
            case "CropSquareTransformation":
                bitmapTransformation = new CropSquareTransformation(mContext);
                break;
            case "RoundedCornersTransformation":
                bitmapTransformation = new RoundedCornersTransformation(mContext, 100, 0, RoundedCornersTransformation.CornerType.ALL);
                break;
            case "ColorFilterTransformation":
                bitmapTransformation = new ColorFilterTransformation(mContext, 0x79008888);
                break;
            case "GrayscaleTransformation":
                bitmapTransformation = new GrayscaleTransformation(mContext);
                break;
            case "BlurTransformation":
                bitmapTransformation = new BlurTransformation(mContext, 100);
                break;
            case "MaskTransformation":
                bitmapTransformation = new MaskTransformation(mContext, R.mipmap.ic_launcher);
                break;
            case "ToonFilterTransformation":
                bitmapTransformation = new ToonFilterTransformation(mContext);
                break;
            case "SepiaFilterTransformation":
                bitmapTransformation = new SepiaFilterTransformation(mContext);
                break;
            case "ContrastFilterTransformation":
                bitmapTransformation = new ContrastFilterTransformation(mContext, 0.5F);
                break;
            case "InvertFilterTransformation":
                bitmapTransformation = new InvertFilterTransformation(mContext);
                break;
            case "PixelationFilterTransformation":
                bitmapTransformation = new PixelationFilterTransformation(mContext);
                break;
            case "SketchFilterTransformation":
                bitmapTransformation = new SketchFilterTransformation(mContext);
                break;
            case "SwirlFilterTransformation":
                bitmapTransformation = new SwirlFilterTransformation(mContext);
                break;
            case "BrightnessFilterTransformation":
                bitmapTransformation = new BrightnessFilterTransformation(mContext, 0.5F);
                break;
            case "KuwaharaFilterTransformation":
                bitmapTransformation = new KuwaharaFilterTransformation(mContext);
                break;
            case "VignetteFilterTransformation":
                bitmapTransformation = new VignetteFilterTransformation(mContext);
                break;
            default:
                break;

        }

        if(bitmapTransformation != null){
            Glide.with(mContext).load(IMAGE_URL).bitmapTransform(bitmapTransformation).into(imageView);
        }else{
            Glide.with(mContext).load(IMAGE_URL).into(imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 添加数据
     * @param datas
     */
    public void addData(@Nullable List<String> datas){
        if(datas != null){
            mDatas.addAll(datas);
            notifyDataSetChanged();
        }
    }

}

