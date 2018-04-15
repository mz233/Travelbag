package com.example.mazhuang.travelbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Payment_Activity extends AppCompatActivity {
    private Button button1;
    private TextView textview1;
    private TextView textview2;
    private TravelBagDB travelDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_payment_);
        button1 = (Button) findViewById(R.id.sub_Btn4);
        textview1 = (TextView) findViewById(R.id.message);
        textview2 = (TextView) findViewById(R.id.cost);
        travelDB = TravelBagDB.getInstance(this);
        //现在是要根据电话号码查找到该人的相关消息，然后显示


        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        String a = bundle.getString("name3");
        String b = bundle.getString("phone3");
        String c = bundle.getString("destination3");
        String d = c + "\n" + a +  "  " + b;
        String e = bundle.getString("bagNum3");
        String f = "行李件数：" + e + "\n" + "费用：10元";
        textview1.setText(d);
        textview2.setText(f);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment_Activity.this, PayWay.class);
                startActivity(intent);
            }
        });
    }
}
