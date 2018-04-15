package com.example.mazhuang.travelbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {
    private Button button1;
    private TravelBagDB travelDB;
    private user user1;
    private EditText editext1;
    private EditText editext2;
    private EditText editext3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        button1 = (Button) findViewById(R.id.login_btn_register);
        travelDB = TravelBagDB.getInstance(this);
        editext1 = (EditText) findViewById(R.id.login_edit_tel);
        editext2 = (EditText) findViewById(R.id.login_edit_pwd);
        editext3 = (EditText) findViewById(R.id.login_edit_repwd);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = editext1.getText().toString();
                String pas1 = editext2.getText().toString();
                String pas2 = editext3.getText().toString();
                if(pas1.equals(pas2)){
                    user1 = new user();
                    user1.setPhone(tel);
                    user1.setPassword(pas1);
                    travelDB.saveUser(user1);
                    Intent intent = new Intent(register.this, login.class);
                    startActivity(intent);
                }


            }
        });
    }
}
