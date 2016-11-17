package com.example.wangnan.glidetransformation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    /**
     * 图片转换类型
     */
    private String[] mGlideTransformationTypes = {
            // 基本图形转换（依赖 compile 'jp.wasabeef:glide-transformations:2.0.1')
            // Crop类型
            "CropTransformation", "CropCircleTransformation", "CropSquareTransformation", "RoundedCornersTransformation",
            // Color类型
            "ColorFilterTransformation", "GrayscaleTransformation",
            // 模糊类型
            "BlurTransformation",
            // 遮罩类型
            "MaskTransformation",
            // GPU Filter (依赖 compile 'jp.co.cyberagent.android.gpuimage:gpuimage-library:1.3.0')
            "ToonFilterTransformation", "SepiaFilterTransformation", "ContrastFilterTransformation",
            "InvertFilterTransformation", "PixelationFilterTransformation", "SketchFilterTransformation",
            "SwirlFilterTransformation", "BrightnessFilterTransformation", "KuwaharaFilterTransformation",
            "VignetteFilterTransformation"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(this, null));
    }

    private void initData() {
        List<String> datas = new ArrayList<String>();
        datas.add("Normal");
        datas.addAll(Arrays.asList(mGlideTransformationTypes));
        ((RecyclerViewAdapter)mRecyclerView.getAdapter()).addData(datas);
    }
}
