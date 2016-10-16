package com.example.administrator.secondproject.downLoad;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/9/7.
 */
public class HandloadJson {

    public static ExecutorService executor = Executors.
            newFixedThreadPool(10);

    public static void downLoadingJson(final String url, final Handler handler) {

        executor.execute(new Runnable() {

            @Override
            public void run() {

                String news = DownLoadUtils.getJsonString(url);
                Log.d("33333333333","====="+news);
                Message message = Message.obtain();
                message.obj = news;
                message.what=1;
                handler.sendMessage(message);

            }
        });

    }

}

