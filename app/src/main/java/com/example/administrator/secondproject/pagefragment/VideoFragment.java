package com.example.administrator.secondproject.pagefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.all_adapters.ViewPagerAdapters;
import com.example.administrator.secondproject.all_fragments.Video_fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class VideoFragment extends Fragment {
    private ViewPager videoViewPager;
    private TabLayout videotabLayout;
    private ViewPagerAdapters adapter;
    String [] titlestr=null;
    String [] urlstr=null;
    List<Fragment>frlist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.video_page,null);
        videoViewPager= (ViewPager) view.findViewById(R.id.video_ViewPagerId);
        videotabLayout= (TabLayout) view.findViewById(R.id.video_tablayoutId);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frlist=new ArrayList<>();
        titlestr=new String []{"大杂烩","笑翻天","奇葩事","娱乐圈","游戏迷"};
        urlstr=new String[]{"http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=255&content_type=3&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474797802955&version=10203&sign=f95dcdfd72afdddfd2af89ee19373fed",
                "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=2&content_type=3&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474797897309&version=10203&sign=6515c4dec260da9182913d87f9b991fa"
                ,"http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=3&content_type=3&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474797924160&version=10203&sign=a555aae71993e6b487e187795cc775db",
                "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=6&content_type=3&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474797963116&version=10203&sign=6eca156fcd8c98169d8e44bd9115993d",
                "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=19&content_type=3&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474797988114&version=10203&sign=7ec55d5cfb914dd7779d8757dc8804e7"};
        initfragment();
        adapter=new ViewPagerAdapters(getFragmentManager(),frlist);
        videoViewPager.setAdapter(adapter);
        videotabLayout.setupWithViewPager(videoViewPager);
        setTabLayout(titlestr,videotabLayout);
    }
    public void setTabLayout(String [] str,TabLayout tabLayout){
        for (int i = 0; i <urlstr.length; i++) {
            tabLayout.getTabAt(i).setText(str[i]);
        }
    }
    private void initfragment() {
        for (int i = 0; i < urlstr.length; i++) {
            frlist.add(new Video_fragment().getInstance(urlstr[i]));
        }
    }
}
