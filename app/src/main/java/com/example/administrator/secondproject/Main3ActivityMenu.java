package com.example.administrator.secondproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.secondproject.all_adapters.EditMenuAdapter;
import com.example.administrator.secondproject.recyclerview_divider.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3ActivityMenu extends AppCompatActivity {
    RecyclerView recyclerViewmenu1,recyclerViewmenu2;
    List<String>list;
    EditMenuAdapter adapter,adapter2;
    List<String>list2;
    TextView edittextview;
    ItemTouchHelper touchHelper;
    ItemTouchHelper.Callback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back_gray);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edittextview= (TextView) findViewById(R.id.menu_bianjiTextviewId);

        edittextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittextview.getText().equals("编辑")){
                    edittextview.setText("完成");
                    edittextview.setTextColor(Color.WHITE);
                    edittextview.setBackgroundResource(R.drawable.edit_shape_press);
                    touchHelper.attachToRecyclerView(recyclerViewmenu1);
                    adapter.onItemclick(new EditMenuAdapter.Onitemchangerlistener() {
                        @Override
                        public void setonitemlistener(View view, String data) {
                            //接口回调拿到点击的内容
                            list.remove(data);
                            adapter.notifyDataSetChanged();
                            list2.add(data);
                            adapter2.notifyDataSetChanged();
                        }
                    });


                } else{
                    edittextview.setText("编辑");
                    edittextview.setTextColor(Color.GREEN);
                    edittextview.setBackgroundResource(R.drawable.edit_shape_normal);
                    touchHelper.attachToRecyclerView(null);
                    adapter.onItemclick(null);
                    Intent data=new Intent();
                    data.putExtra("he","你回来了");
                    setResult(200,data);
                }
            }
        });
        initview();
        initdata();
        adapter=new EditMenuAdapter(list,getApplicationContext());
        adapter2=new EditMenuAdapter(list2,getApplicationContext());
        recyclerViewmenu1.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        recyclerViewmenu2.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        int spacingInPixels = 8;
        recyclerViewmenu1.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerViewmenu1.setAdapter(adapter);
        recyclerViewmenu2.setAdapter(adapter2);

        callback= new ItemTouchHelper.Callback() {
            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                // 拖拽的标记，这里允许上下左右四个方向
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT |
                        ItemTouchHelper.RIGHT;
                // 滑动的标记，这里允许左右滑动
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Collections.swap(list, viewHolder.getAdapterPosition(), target
                        .getAdapterPosition());
                return true;
            }

            @Override
            public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
                super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target
                        .getAdapterPosition());
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // 将数据集中的数据移除
                list.remove(viewHolder.getAdapterPosition());
                // 刷新列表
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        };
        touchHelper=new ItemTouchHelper(callback);

    }

 String[] titlesls={"推荐","社会","搞笑","奇闻","励志","娱乐","科技","百科","财经","汽车",
         "情感","星座","美食","时尚","旅游","育儿","体育","军事"};
    private void initdata() {
        list2=new ArrayList<>();
        list=new ArrayList<>();
        for (int i = 0; i < titlesls.length; i++) {
           list.add(titlesls[i]);
        }

    }

    private void initview() {
        recyclerViewmenu1= (RecyclerView) findViewById(R.id.menu1_recylerview);
        recyclerViewmenu2= (RecyclerView) findViewById(R.id.menu2_recylayview);
    }

}
