package com.bawei.qinchaomeng20190415.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.qinchaomeng20190415.R;
import com.bumptech.glide.Glide;

public class TuActivity extends AppCompatActivity {

    private ImageView tu_tu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu);
        //初始化ID
         tu_tu = findViewById(R.id.tu_tu);

    }
}
