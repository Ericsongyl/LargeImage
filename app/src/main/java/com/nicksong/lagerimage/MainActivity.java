package com.nicksong.lagerimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {
    private View btnLocalImg;
    private View btnViewPageImg;
    private View btnNetImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        btnLocalImg = findViewById(R.id.btn_local_image);
        btnViewPageImg = findViewById(R.id.btn_viewpage_image);
        btnNetImg = findViewById(R.id.btn_net_image);
    }

    private void initListener() {
        btnLocalImg.setOnClickListener(onClickListener);
        btnViewPageImg.setOnClickListener(onClickListener);
        btnNetImg.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_local_image:
                    startActivity(new Intent(getApplicationContext(), SingleDemoActivity.class));
                    break;
                case R.id.btn_viewpage_image:
                    startActivity(new Intent(getApplicationContext(),ViewPagerDemoActivity.class));
                    break;
                case R.id.btn_net_image:
                    startActivity(new Intent(getApplicationContext(),NetworkDemoActivity.class));
                    break;
                default:
                    break;
            }
        }
    };
}
