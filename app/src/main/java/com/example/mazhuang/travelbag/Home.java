package com.example.mazhuang.travelbag;

import java.util.ArrayList;
import java.util.List;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.app.Activity;

public class Home extends AppCompatActivity {
    private List<View> views = new ArrayList<View>();
    private ViewPager viewPager;//用于选择界面
    private LinearLayout llChat, llFriends, llContacts;
    private TextView tvChat, tvFriends, tvContacts, tvCurrent;
    private LocalActivityManager manager;
    private Intent intentMain,intentOrder,intentSelf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        initView();
        initData(savedInstanceState);
    }
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        llChat = (LinearLayout) findViewById(R.id.llChat);
        llFriends = (LinearLayout) findViewById(R.id.llFriends);
        llContacts = (LinearLayout) findViewById(R.id.llContacts);

        //设置事件响应
        llChat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvCurrent.setSelected(false);
                viewPager.setCurrentItem(0);
                tvChat.setSelected(true);
                tvCurrent = tvChat;
                //do something
            }
        });
        llFriends.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvCurrent.setSelected(false);
                viewPager.setCurrentItem(1);
                tvFriends.setSelected(true);
                tvCurrent = tvFriends;
                //do something
            }
        });
        llContacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvCurrent.setSelected(false);
                viewPager.setCurrentItem(2);
                tvContacts.setSelected(true);
                tvCurrent = tvContacts;
                //do something
            }
        });




        //找到各个控件对象
        tvChat = (TextView) findViewById(R.id.tvChat);
        tvFriends = (TextView) findViewById(R.id.tvFriends);
        tvContacts = (TextView) findViewById(R.id.tvContacts);


        //此时选中的为tvChat
        tvChat.setSelected(true);
        tvCurrent = tvChat;

        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void initData(Bundle savedInstanceState) {
        LayoutInflater mInflater = LayoutInflater.from(this);



        MyPagerAdapter adapter = new MyPagerAdapter(views);






        manager = new LocalActivityManager(this, true);
        manager.dispatchCreate(savedInstanceState);

        intentMain = new Intent(Home.this, MainFrame.class);
        View tab01 = manager.startActivity("viewID", intentMain).getDecorView();
        intentOrder = new Intent(Home.this, order_main.class);
        View tab02 = manager.startActivity("viewID", intentOrder).getDecorView();
        intentSelf = new Intent(Home.this, Self.class);
        View tab03 = manager.startActivity("viewID", intentSelf).getDecorView();

        views.add(tab01);//将页面添加到View集合
        views.add(tab02);
        views.add(tab03);
        viewPager.setAdapter(adapter);// 配置适配器
    }


    public void onClick(View v) {
        changeTab(v.getId());
    }

    private void changeTab(int id) {

        tvCurrent.setSelected(false);
        switch (id) {
            case R.id.llChat:
                viewPager.setCurrentItem(0);
            case 0:
                tvChat.setSelected(true);
                tvCurrent = tvChat;
                break;
            case R.id.llFriends:
                viewPager.setCurrentItem(1);
            case 1:
                tvFriends.setSelected(true);
                tvCurrent = tvFriends;
                break;
            case R.id.llContacts:
                viewPager.setCurrentItem(2);
            case 2:
                tvContacts.setSelected(true);
                tvCurrent = tvContacts;
                break;
            default:
                break;
        }
    }

}

