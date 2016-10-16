package com.example.administrator.secondproject.updownrefresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/27.继承swiprefresh实现下拉加载
 */
public class MyswipeRefreshLayout extends SwipeRefreshLayout {

    boolean isRefreshing=false;
    OnUpRefreshListener upListener;//接口对象
    RecyclerView recyclerview;//使用此变量设置滑动方法
    int touchSlot=0;//定义滑动的最小值
    float downY,lastY;
    boolean isUpto=false;//判断是否向上滑动
    public MyswipeRefreshLayout(Context context) {
        this(context, null);
    }

    public MyswipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        touchSlot= 200;//ViewConfiguration.getTouchSlop();//获取移动的最小值
    }
    //来对view进行布局
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (recyclerview==null){
            for (int i = 0; i < getChildCount(); i++) {
                View view=getChildAt(i);
                if (view instanceof RecyclerView){
                    recyclerview= (RecyclerView) view;
                    //拿到recyclerview设置滑动监听
                    recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                            super.onScrollStateChanged(recyclerView, newState);
                            if (newState==RecyclerView.SCROLL_STATE_IDLE
                                    && isUpto){
                                upListener.OnUpRefresh();
                                //当条件成熟时来调用接口方法
                            }
                        }

                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                            super.onScrolled(recyclerView, dx, dy);
                        }
                    });
                }
            }
        }

    }

    //事件分发的方法
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                downY=ev.getY();//获取开始滑动的位置
                break;
            case MotionEvent.ACTION_UP:
                if ((downY-lastY)>touchSlot){
                    isUpto=true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                lastY=ev.getY();
                break;
        }

        return super.dispatchTouchEvent(ev);
    }

    //提供一个方法来设置是否刷新
    public void setUpResfrshing(boolean isRefresh){
        if (isRefresh){
            isRefreshing=true;
            //在此处添加尾部视图
            Toast.makeText(getContext(),"开始刷新。。。",Toast.LENGTH_SHORT).show();
        }else{
            isRefreshing=false;
            //此处干掉尾部视图
            Toast.makeText(getContext(),"结束刷新。。。",Toast.LENGTH_SHORT).show();
        }
    }

    //提供一个方法来让外界调用，接收传入的listener
    public void setOnUpRefreshListener(OnUpRefreshListener listener){
        this.upListener=listener;
    }
    //定义一个接口来实现上拉监听
    public interface OnUpRefreshListener{
        void OnUpRefresh();
    }
}
