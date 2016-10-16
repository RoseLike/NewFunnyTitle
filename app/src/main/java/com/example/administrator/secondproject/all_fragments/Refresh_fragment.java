package com.example.administrator.secondproject.all_fragments;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.all_adapters.RefreshAdapters;
import com.example.administrator.secondproject.data.Refreshdata;
import com.example.administrator.secondproject.downLoad.HandloadJson;
import com.example.administrator.secondproject.gsonjx.GetgsonFrushData;
import com.example.administrator.secondproject.recyclerview_divider.SimpleDividerItemDecoration;
import com.example.administrator.secondproject.updownrefresh.MyswipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class Refresh_fragment extends Fragment implements MyswipeRefreshLayout.OnUpRefreshListener, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private List<Refreshdata>list=new ArrayList<>();
    private RefreshAdapters adapter;
    private MyswipeRefreshLayout myswipeRefreshLayout;
    String url="";
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String TjString= (String) msg.obj;
                    if (TextUtils.isEmpty(TjString)) return;
                    List<Refreshdata> flist= GetgsonFrushData.getgson(TjString);
                    flist.remove(1);
                    list.addAll(0,flist);
                    adapter.notifyDataSetChanged();
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
                    String TjString= (String) msg.obj;
                    if (TextUtils.isEmpty(TjString)) return;
                    List<Refreshdata> flist= GetgsonFrushData.getgson(TjString);
                    flist.remove(1);
                    list.addAll(flist);
                    adapter.notifyDataSetChanged();
                    break;
            }

        }
    };
    //单例模式传值
    public Refresh_fragment getStringurl(String urls){
        Refresh_fragment fragment=new Refresh_fragment();
        Bundle bundle=new Bundle();
        bundle.putString("mm",urls);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_layout,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerId);
        myswipeRefreshLayout= (MyswipeRefreshLayout) view.findViewById(R.id.swipeId);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        url=getArguments().getString("mm");
        HandloadJson.downLoadingJson(url,handler);
        adapter=new RefreshAdapters(list,getActivity());
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myswipeRefreshLayout.setColorSchemeColors(Color.CYAN,Color.YELLOW,Color.GREEN);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerview的分割线
        Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.line_divider);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext(),drawable, 10));
        recyclerView.setAdapter(adapter);
        //实现上拉加载，下拉刷新
        myswipeRefreshLayout.setOnUpRefreshListener(this);
        myswipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void OnUpRefresh() {
        myswipeRefreshLayout.setUpResfrshing(true);
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
                        HandloadJson.downLoadingJson(url,handler2);
                        myswipeRefreshLayout.setUpResfrshing(false);
                        recyclerView.scrollToPosition(list.size()-1);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onRefresh() {
        myswipeRefreshLayout.setRefreshing(true);
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
                        myswipeRefreshLayout.setRefreshing(false);
                    }
                });
            }

        }).start();
    }
}
