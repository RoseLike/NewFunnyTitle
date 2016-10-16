package com.example.administrator.secondproject.pagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.administrator.secondproject.Main3ActivityMenu;
import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.all_adapters.ViewPagerAdapters;
import com.example.administrator.secondproject.all_fragments.Refresh_fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class RefreshFragment extends android.support.v4.app.Fragment implements  View.OnClickListener {
    public static final String TJ_URL = "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=255&content_type=1%2C2%2C4&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474795785116&version=10203&sign=ade3a48c837722e20ca565ee6ecc5775";
    public static final String SH_URL = "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=1&content_type=1%2C2%2C4&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474795856127&version=10203&sign=27879e56dabeb803ac9753a6506d1058";
    public static final String FUNNY_URL = "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=2&content_type=1%2C2%2C4&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474795882034&version=10203&sign=56167f2427ba3522f350b90f50f9a540";
    public static final String QIWEN_URL = "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=3&content_type=1%2C2%2C4&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474795925805&version=10203&sign=dea9c3e5b0335e618ac2bf28e92e7f5c";
    public static final String YA_URL = "http://api.1sapp.com/content/getList?OSVersion=5.1.1&cid=5&content_type=1%2C2%2C4&deviceCode=867676023622300&dtu=014&lat=0.0&lon=0.0&max_time=0&op=2&page=1&show_time=0&time=1474795989965&version=10203&sign=7731a346a4fa891c0783a1d8e03b1281";
    private ViewPager refreshviewPager;
    private TabLayout tabLayout;
    private ImageButton imagebutton;
    private List<Fragment> list;
    private ViewPagerAdapters adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.refresh_page, null);
        refreshviewPager = (ViewPager) view.findViewById(R.id.FrushFragment_ViewId);
        tabLayout = (TabLayout) view.findViewById(R.id.refresh_tablayoutId);
        imagebutton = (ImageButton) view.findViewById(R.id.refresh_ImagebuttonId);
        return view;
    }

    private void initdata() {
        list = new ArrayList<>();
        list.add(new Refresh_fragment().getStringurl(TJ_URL));
        list.add(new Refresh_fragment().getStringurl(SH_URL));
        list.add(new Refresh_fragment().getStringurl(FUNNY_URL));
        list.add(new Refresh_fragment().getStringurl(QIWEN_URL));
        list.add(new Refresh_fragment().getStringurl(YA_URL));

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata();
        adapter = new ViewPagerAdapters(getActivity().getSupportFragmentManager(), list);
        refreshviewPager.setAdapter(adapter);
        imagebutton.setOnClickListener(this);
        String[] titlestr = {"推荐", "社会", "搞笑", "奇闻", "励志"};
        tabLayout.setupWithViewPager(refreshviewPager);
        setTabLayout(titlestr, tabLayout);

    }

    public void setTabLayout(String[] str, TabLayout tabLayout) {
        for (int i = 0; i < str.length; i++) {
            tabLayout.getTabAt(i).setText(str[i]);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), Main3ActivityMenu.class);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==200){
            String result=data.getStringExtra("he");
            Log.d("99999999999999","==========="+result);
        }
    }
}
