package com.nicksong.lagerimage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import lagerimage.nicksong.view.largeimage.LargeImageView;
import lagerimage.nicksong.view.largeimage.factory.InputStreamBitmapDecoderFactory;

import java.io.IOException;
import java.io.InputStream;

public class SingleDemoActivity extends FragmentActivity {

    private ImageView ivBack;
    private LargeImageView largeImageView;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singledemo);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        largeImageView = (LargeImageView) findViewById(R.id.imageView);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
    }

    private void initListener() {
        ivBack.setOnClickListener(onClickListener);
        toggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        largeImageView.setOnClickListener(onClickListener);
        largeImageView.setOnLongClickListener(onLongClickListener);
        largeImageView.setCriticalScaleValueHook(new LargeImageView.CriticalScaleValueHook() {
            @Override
            public float getMinScale(LargeImageView largeImageView, int imageWidth, int imageHeight, float suggestMinScale) {
                return 1;
            }

            @Override
            public float getMaxScale(LargeImageView largeImageView, int imageWidth, int imageHeight, float suggestMaxScale) {
                return 4;
            }
        });
    }

    private void initData() {
        try {
            InputStream inputStream = getAssets().open("hulianwang.jpg");
            largeImageView.setImage(new InputStreamBitmapDecoderFactory(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.iv_back) {
                finish();
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            if (v == largeImageView) {
                Toast.makeText(getApplicationContext(), "长按事件", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            largeImageView.setEnabled(!isChecked);
        }
    };

    private LargeImageView.CriticalScaleValueHook criticalScaleValueHook = new LargeImageView.CriticalScaleValueHook() {
        @Override
        public float getMinScale(LargeImageView largeImageView, int imageWidth, int imageHeight, float suggestMinScale) {
            return 1;
        }

        @Override
        public float getMaxScale(LargeImageView largeImageView, int imageWidth, int imageHeight, float suggestMaxScale) {
            return 4;
        }
    };
}
