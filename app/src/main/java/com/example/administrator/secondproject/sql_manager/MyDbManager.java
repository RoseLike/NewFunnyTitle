package com.example.administrator.secondproject.sql_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28.
 * SQL管理类
 */
public class MyDbManager {
   Context context;
    MysqlOpenHelper openHelper;
    SQLiteDatabase database;
    public MyDbManager(Context context) {
        this.context = context;
        openHelper=new MysqlOpenHelper(context);
        database=openHelper.getWritableDatabase();
    }
    //添加方法
    public void addsql(Mydata mydata){
        ContentValues values=new ContentValues();
        values.put("title",mydata.getTittle());
        values.put("httpUrl",mydata.getHttpUrl());
        values.put("imageUrl",mydata.getImageUrl());
        database.insert("collect",null,values);

    }
    //删除方法
    public void delete(String deletetitle){
        database.delete("collect", "title=?", new String[]{deletetitle});
    }
    //便利数据库拿到所有数据
    public List<Mydata> qurey(){
        List<Mydata> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("select * from collect",null);
        while(cursor.moveToNext()){
          Mydata mydata=new Mydata();
            mydata.tittle=cursor.getString(cursor.getColumnIndex("title"));
            mydata.httpUrl=cursor.getString(cursor.getColumnIndex("httpUrl"));
            mydata.imageUrl=cursor.getString(cursor.getColumnIndex("imageUrl"));
            list.add(mydata);
        }
        return  list;
    }

}
