package com.example.mazhuang.travelbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Wait_Fetch_Activity extends AppCompatActivity {
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wait__fetch_);
        button1 = (Button) findViewById(R.id.sub_Btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wait_Fetch_Activity.this, CreateOrder.class);
                startActivity(intent);
            }
        });
    }
}
