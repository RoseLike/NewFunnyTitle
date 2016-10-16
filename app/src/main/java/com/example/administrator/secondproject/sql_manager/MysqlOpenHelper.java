package com.example.administrator.secondproject.sql_manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/28.
 */
public class MysqlOpenHelper extends SQLiteOpenHelper {
   private static final String SQL_Name="collect.db";
    private static  final int VERSION_NUM=1;
    public MysqlOpenHelper(Context context) {
        super(context, SQL_Name,null,VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库
        String sql="create table collect(_id integer primary key autoincrement,title varchar(40),httpUrl varchar(40),imageUrl varchar(40))";
        db.execSQL(sql);//执行创建语句
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          //更新数据库

    }
}
