package com.example.mazhuang.travelbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class CreateOrder extends AppCompatActivity {
    private Button button1;
    private EditText name;
    private EditText phone;
    private EditText destination;
    private EditText bagNum;
    private EditText time;
    private TravelBagDB travelDB;
    private Order order2;
    public static String current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_create_order);
        button1 = (Button) findViewById(R.id.sub_Btn3);
        name = (EditText) findViewById(R.id.name1);
        phone = (EditText) findViewById(R.id.phone1);
        destination = (EditText) findViewById(R.id.address1);
        bagNum = (EditText) findViewById(R.id.bag);
        travelDB = TravelBagDB.getInstance(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2 = name.getText().toString();
                String phone2 = phone.getText().toString();
                String destination2 = destination.getText().toString();
                String bagNum2 = bagNum.getText().toString();
                int num = Integer.parseInt(bagNum2);
                order2 = new Order();
                order2.setName(name2);
                order2.setPhone(phone2);
                order2.setDestination(destination2);
                order2.setBagNum(num);
                travelDB.saveOrder(order2);
                current = phone2;
                Intent intent = new Intent(CreateOrder.this, Payment_Activity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                //传递name参数为tinyphp
                bundle.putString("name3", name2);
                bundle.putString("phone3", phone2);
                bundle.putString("destination3", destination2);
                bundle.putString("bagNum3", bagNum2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
