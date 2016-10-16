package com.example.administrator.secondproject.all_fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.all_adapters.Videoadapters;
import com.example.administrator.secondproject.data.Videodata;
import com.example.administrator.secondproject.downLoad.HandloadJson;
import com.example.administrator.secondproject.gsonjx.GetgsonVideoData;
import com.example.administrator.secondproject.recyclerview_divider.SimpleDividerItemDecoration;
import com.example.administrator.secondproject.updownrefresh.MyswipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public class Video_fragment extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener, MyswipeRefreshLayout.OnUpRefreshListener {
   RecyclerView recyclerView;
    MyswipeRefreshLayout swipeRefreshLayout;
    List<Videodata>datalist=new ArrayList<>();
    String url="";
    Videoadapters videoadapter;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String json= (String) msg.obj;
                    List<Videodata>list= GetgsonVideoData.getgson(json);
                    list.remove(2);
                    datalist.addAll(0,list);
                    videoadapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    Handler handler2=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String json= (String) msg.obj;
                    List<Videodata>list=GetgsonVideoData.getgson(json);
                    list.remove(2);
                    datalist.addAll(list);
                    videoadapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    public Video_fragment getInstance(String url){
        Video_fragment myfragment=new Video_fragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        myfragment.setArguments(bundle);
        return  myfragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_layout,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerId);
        swipeRefreshLayout= (MyswipeRefreshLayout) view.findViewById(R.id.swipeId);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        url=getArguments().get("url").toString();
         HandloadJson.downLoadingJson(url,handler);
         videoadapter=new Videoadapters(datalist,getActivity());
        //设置 进度条的颜色变化最多可以设置4种颜色
         swipeRefreshLayout.setColorSchemeColors(Color.CYAN,Color.YELLOW,Color.GREEN);
        //第一次进入页面的时候显示加载进度条
        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.line_divider);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext(),drawable, 10));
        recyclerView.setAdapter(videoadapter);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setOnUpRefreshListener(this);
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              getActivity().runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      HandloadJson.downLoadingJson(url,handler);
                      swipeRefreshLayout.setRefreshing(false);
                  }
              });
            }

        }).start();
    }

    @Override
    public void OnUpRefresh() {
        swipeRefreshLayout.setUpResfrshing(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //添加数据并调用   更新结束
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        HandloadJson.downLoadingJson(url,handler2);
                        swipeRefreshLayout.setUpResfrshing(false);
                        recyclerView.scrollToPosition(datalist.size()-1);
                    }
                });
            }
        }).start();
    }
}
