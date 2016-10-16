package com.example.administrator.secondproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main4Activitystart extends AppCompatActivity {
//    Handler handler=new Handler(){
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Intent intent=new Intent(Main4Activitystart.this,MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_activitystart);
//        Message message=Message.obtain();
//        message.what=1;
//        handler.sendMessageDelayed(message,3000);
         Intent intent=new Intent(Main4Activitystart.this,MainActivity.class);
         startActivity(intent);
            finish();
    }


}
