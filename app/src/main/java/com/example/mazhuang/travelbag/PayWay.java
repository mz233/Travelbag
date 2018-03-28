package com.example.mazhuang.travelbag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class PayWay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pay_way);
    }
}
