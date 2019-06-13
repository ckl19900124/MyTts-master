package com.example.mytts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this,com.iflytek.mscv5plusdemo.MainActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this,com.iflytek.voicedemo.MainActivity.class));
                break;
        }
    }
}
