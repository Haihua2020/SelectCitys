package com.example.zhanghaihua.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhanghaihua.myapplication.diyView.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
