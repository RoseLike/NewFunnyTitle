package com.example.administrator.secondproject.pagefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.secondproject.R;

/**
 * Created by Administrator on 2016/9/26.
 */
public class FrushFragment extends Fragment {
    ViewPager FrushviewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frushfragment_viewpager,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FrushviewPager= (ViewPager) view.findViewById(R.id.FrushFragment_ViewId);
    }
}
