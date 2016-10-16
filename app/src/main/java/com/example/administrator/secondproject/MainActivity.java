package com.example.administrator.secondproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.secondproject.all_adapters.ViewPagerAdapters;
import com.example.administrator.secondproject.pagefragment.PersonFragment;
import com.example.administrator.secondproject.pagefragment.RefreshFragment;
import com.example.administrator.secondproject.pagefragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements  View.OnClickListener {
    private ViewPager viewPager;
    private List<Fragment>list;
    private ViewPagerAdapters adapter;
    private ImageView imageView1, imageView2, imageView3;
    private TextView textView1, textView2, textView3;
    private View view, view2, view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = (ImageView) findViewById(R.id.relative_imageId);
        imageView2 = (ImageView) findViewById(R.id.relative_imageId2);
        imageView3 = (ImageView) findViewById(R.id.relative_imageId3);
        textView1 = (TextView) findViewById(R.id.relative_textId);
        textView2 = (TextView) findViewById(R.id.relative_textId2);
        textView3 = (TextView) findViewById(R.id.relative_textId3);
        view = findViewById(R.id.relativeid);
        view2 = findViewById(R.id.relativeid2);
        view3 = findViewById(R.id.relativeid3);
        view.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        viewPager= (ViewPager) findViewById(R.id.mainViewPagerId);
        initData();
        adapter=new ViewPagerAdapters(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
    }

    private void initData() {
        list=new ArrayList<>();
        RefreshFragment refreshFragment =new RefreshFragment();
        PersonFragment myFragment=new PersonFragment();
        VideoFragment videoFragment=new VideoFragment();
        list.add(refreshFragment);
        list.add(videoFragment);
        list.add(myFragment);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.relativeid) {
            viewPager.setCurrentItem(0);
            textView1.setTextColor(Color.GREEN);
            textView2.setTextColor(Color.BLACK);
            textView3.setTextColor(Color.BLACK);
            imageView1.setImageResource(R.drawable.icon_main_tab_news_selected);
            imageView2.setImageResource(R.drawable.icon_main_tab_video_normal);
            imageView3.setImageResource(R.drawable.icon_main_tab_person_normal);
        } else if (id == R.id.relativeid2) {
            viewPager.setCurrentItem(1);
            textView2.setTextColor(Color.GREEN);
            textView1.setTextColor(Color.BLACK);
            textView3.setTextColor(Color.BLACK);
            imageView2.setImageResource(R.drawable.icon_main_tab_video_selected);
            imageView1.setImageResource(R.drawable.icon_main_tab_news_normal);
            imageView3.setImageResource(R.drawable.icon_main_tab_person_normal);
        } else if (id == R.id.relativeid3) {
            viewPager.setCurrentItem(2);
            textView3.setTextColor(Color.GREEN);
            textView1.setTextColor(Color.BLACK);
            textView2.setTextColor(Color.BLACK);
            imageView3.setImageResource(R.drawable.icon_main_tab_person_selected);
            imageView1.setImageResource(R.drawable.icon_main_tab_news_normal);
            imageView2.setImageResource(R.drawable.icon_main_tab_video_normal);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
