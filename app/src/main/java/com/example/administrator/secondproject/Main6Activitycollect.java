package com.example.administrator.secondproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.secondproject.sql_manager.MyDbManager;
import com.example.administrator.secondproject.sql_manager.Mydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main6Activitycollect extends AppCompatActivity {
    ListView collectlistview;
    List<Mydata> collectlist;
    SimpleAdapter simpleAdapter;
    MyDbManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6_activitycollect);
        manager=new MyDbManager(getApplicationContext());
        collectlistview= (ListView) findViewById(R.id.collectListId);
        inticollectdata();
    }

    private void inticollectdata() {
        collectlist= manager.qurey();
        List<Map<String,Object>>finaldata=new ArrayList<>();
        Map<String,Object>map=null;
        for(Mydata mydata:collectlist){
            map=new HashMap();
            map.put("title",mydata.getTittle());
            map.put("httpUrl",mydata.getHttpUrl());
            map.put("imageUrl",mydata.getImageUrl());
            finaldata.add(map);
        }
        simpleAdapter=new SimpleAdapter(getApplicationContext(),finaldata,R.layout.collect_item,new String[]{"title","httpUrl","imageUrl"},new int[]{R.id.titleId,R.id.httpUrlId,R.id.imageUrLId});
        collectlistview.setAdapter(simpleAdapter);
    }
}
