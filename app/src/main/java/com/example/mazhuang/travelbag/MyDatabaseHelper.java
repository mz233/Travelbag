package com.example.mazhuang.travelbag;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by mazhuang on 2018/4/11.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_USER = "create table user ("
            + "phone text primary key, "
            + "password text)";

    public static final String CREATE_ADDRESS = "create table address ("
            + "phone text primary key, "
            + "name text, "
            + "destination text)";
    /**
     * City表建表语句 订单编号，订单所属人，订单电话，目的地，行李件数，送达时间，订单状态，订单金额，首发驿站，当前驿站
     */
    public static final String CREATE_ORDER = "create table order1 ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "phone text, "
            + "destination text, "
            + "bagNum integer, "
            + "arriveTime timestamp, "
            + "status integer, "
            + "price real, "
            + "firstStation text, "
            + "nowStation text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_ORDER);
        db.execSQL(CREATE_ADDRESS);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
