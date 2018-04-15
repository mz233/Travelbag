package com.example.mazhuang.travelbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    private Button button1;
    private TravelBagDB travelDB;
    private EditText editext1;
    private EditText editext2;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        button1 = (Button) findViewById(R.id.login_btn_register);
        button2 =  (Button) findViewById(R.id.login_btn_login);
        travelDB = TravelBagDB.getInstance(this);
        editext1 = (EditText) findViewById(R.id.login_edit_account);
        editext2 = (EditText) findViewById(R.id.login_edit_pwd);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = editext1.getText().toString();
                String pwd = editext2.getText().toString();
                if(account.equals(pwd)){

                    Intent intent = new Intent(login.this, Self.class);
                    startActivity(intent);
                }
            }
        });
    }
}
