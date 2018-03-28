package com.example.mazhuang.travelbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CreateOrder extends AppCompatActivity {
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_create_order);
        button1 = (Button) findViewById(R.id.sub_Btn3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateOrder.this, Payment_Activity.class);
                startActivity(intent);
            }
        });

    }
}
