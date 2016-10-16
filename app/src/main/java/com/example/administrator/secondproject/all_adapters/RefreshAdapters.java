package com.example.administrator.secondproject.all_adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.secondproject.Main2Activity;
import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.data.Refreshdata;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class RefreshAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    List<Refreshdata> list;
    Context context;

    public RefreshAdapters(List<Refreshdata> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPE_1:
                view = LayoutInflater.from(context).inflate(R.layout.refresh_item1, null);
                holder = new MyViewHolder1(view);
                break;
            case TYPE_2:
                view = LayoutInflater.from(context).inflate(R.layout.refresh_item2, null);
                holder = new MyViewHolder2(view);
                break;
        }
        return holder;
    }
    Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(currentTime);
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case 0:
                MyViewHolder1 myViewHolder1 = (MyViewHolder1) holder;
                ((MyViewHolder1) holder).item1Titleview.setText(list.get(position).getTitle());
                Picasso.with(context).load(list.get(position).getCover().get(0)).placeholder(R.mipmap.img_news_default).into(((MyViewHolder1) holder).item1Imageview);
                ((MyViewHolder1) holder).item1Numview.setText("阅读量"+list.get(position).getRead_count());
                ((MyViewHolder1) holder).item1Timeview.setText(dateString);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Main2Activity.class);
                        String urls = list.get(position).getUrl();
                        intent.putExtra("ma", urls);
                        context.startActivity(intent);
                    }
                });
                break;
            case 1:
                MyViewHolder2 myViewHolder2 = (MyViewHolder2) holder;
                ((MyViewHolder2) holder).item2Titleview.setText(list.get(position).getTitle());
                ((MyViewHolder2) holder).item2Timeview.setText(dateString);
                ((MyViewHolder2) holder).item2Numview.setText("阅读量"+list.get(position).getRead_count());
                Picasso.with(context).load(list.get(position).getCover().get(0)).placeholder(R.mipmap.img_news_default).into(((MyViewHolder2) holder).item2imageview1);
                Picasso.with(context).load(list.get(position).getCover().get(1)).placeholder(R.mipmap.img_news_default).into(((MyViewHolder2) holder).item2imageview2);
                Picasso.with(context).load(list.get(position).getCover().get(2)).placeholder(R.mipmap.img_news_default).into(((MyViewHolder2) holder).item2imageview3);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Main2Activity.class);
                        String urls = list.get(position).getUrl();
                        intent.putExtra("ma", urls);
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if ((list.get(position).getCover_show_type()).equals("1")) {
            type = TYPE_1;
        } else if ((list.get(position).getCover_show_type()).equals("3")) {
            type = TYPE_2;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView item1Imageview;
        TextView item1Titleview, item1Numview, item1Timeview;

        public MyViewHolder1(View itemView) {
            super(itemView);
            item1Imageview = (ImageView) itemView.findViewById(R.id.item_imageId);
            item1Titleview = (TextView) itemView.findViewById(R.id.item_titletextId);
            item1Numview = (TextView) itemView.findViewById(R.id.item_numId);
            item1Timeview = (TextView) itemView.findViewById(R.id.item_timeId);

        }

    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView item2Titleview, item2Numview, item2Timeview;
        ImageView item2imageview1, item2imageview2, item2imageview3;

        public MyViewHolder2(View itemView) {
            super(itemView);
            item2Titleview = (TextView) itemView.findViewById(R.id.item2_titletextId);
            item2Numview = (TextView) itemView.findViewById(R.id.item2_numId);
            item2Timeview = (TextView) itemView.findViewById(R.id.item2_timeId);
            item2imageview1 = (ImageView) itemView.findViewById(R.id.item2_imageview_1);
            item2imageview2 = (ImageView) itemView.findViewById(R.id.item2_imageview_2);
            item2imageview3 = (ImageView) itemView.findViewById(R.id.item2_imageview_3);
        }
    }
}
