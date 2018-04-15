package com.example.mazhuang.travelbag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazhuang on 2018/4/12.
 */
public class TravelBagDB {
    /**
     * 数据库名
     */
    public static final String DB_NAME = "travel_bag";

    /**
     * 数据库版本
     */
    public static final int VERSION = 1;

    private static TravelBagDB travelBagDB;

    private SQLiteDatabase db;
    private Context mContext;

    /**
     * 将构造方法私有化
     */
    private TravelBagDB(Context context) {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(context,
                DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
        mContext = context;
    }
    /**
     * 获取TravelBagDB的实例。
     */
    public synchronized static TravelBagDB getInstance(Context context) {
        if (travelBagDB == null) {
            travelBagDB = new TravelBagDB(context);
        }
        return travelBagDB;
    }
    /**
     * 将User实例存储到数据库。
     */
    public void saveUser(user user) {
        if (user != null) {
            ContentValues values = new ContentValues();
            values.put("phone", user.getPhone());
            values.put("password", user.getPassword());
            db.insert("user", null, values);
            Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 从数据库读取所有的用户信息。
     */
    public List<user> loadProvinces() {
        List<user> list = new ArrayList<user>();
        Cursor cursor = db
                .query("user", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                user user = new user();
                user.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                user.setPassword(cursor.getString(cursor
                        .getColumnIndex("password")));
                list.add(user);
            } while (cursor.moveToNext());
        }
        return list;
    }
    /**
     * 将order实例存储到数据库。
     */
    public void saveOrder(Order order) {
        if (order != null) {
            String name=order.getName();
            String phone=order.getPhone();
            String destination=order.getDestination();
            int bagNum=order.getBagNum();
            Timestamp arriveTime=order.getArriveTime();
            double price= 5;
            String firstStation= "whut";
            String nowStation= "whut";
            int status= 1;
            db.execSQL("insert into order1 (name, phone, destination, bagNum, arriveTime, price, firstStation, nowStation, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new Object[] { name, phone, destination, bagNum, arriveTime, price, firstStation, nowStation, status});
        }
    }
    /**
     * 将order实例存储到数据库。
     */
    public void saveAddress(Address address) {
        if (address != null) {
            ContentValues values = new ContentValues();
            values.put("phone", address.getPhone());
            values.put("password", address.getName());
            values.put("destination", address.getDestination());
            db.insert("address", null, values);
        }
    }

}
