package com.example.administrator.secondproject.all_adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.secondproject.Main2Activity;
import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.data.Videodata;
import com.example.administrator.secondproject.sql_manager.MyDbManager;
import com.example.administrator.secondproject.sql_manager.Mydata;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2016/9/27.
 */
public class Videoadapters extends RecyclerView.Adapter<Videoadapters.MyviewHolder> {
    List<Videodata>list;
    Context context;
    int num=0;
    boolean iscollect=false;
    MyDbManager manager;
    public Videoadapters(List<Videodata> list, Context context) {
        this.list = list;
        this.context = context;
        manager=new MyDbManager(context);
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_item,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
            }
        });
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyviewHolder holder, final int position) {
         holder.numtext.setText(list.get(position).getRead_count()+"次播放");
         holder.frametext.setText(list.get(position).getTitle());
         Picasso.with(context).load(list.get(position).getCover().get(0)).into(holder.imageView);
         holder.collectimagbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                if (!iscollect){
                     manager.addsql(new Mydata(list.get(position).getTitle(),list.get(position).getUrl(),list.get(position).getCover().get(0)));
                     iscollect=true;
                     holder.collectimagbutton.setImageResource(R.drawable.rating_star_on);
                 } else{
                    manager.delete(list.get(position).getTitle());
                    iscollect=false;
                    holder.collectimagbutton.setImageResource(R.drawable.rating_star_off);
                }


             }
         });
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                String urls = list.get(position).getUrl();
                intent.putExtra("ma", urls);
                context.startActivity(intent);
            }
        });
        holder.shareimagbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnekeyShare oks = new OnekeyShare();
                oks.disableSSOWhenAuthorize();
                oks.setTitle("分享");
                oks.setText("快看看有惊喜");
                oks.setExecuteUrl(list.get(position).getUrl());
                oks.show(context);
            }
        });
        iscollect=false;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    class MyviewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView imageView;
        TextView numtext,frametext;
        ImageButton collectimagbutton,shareimagbutton;
        public MyviewHolder(View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.video_relativeId);
            imageView= (ImageView) itemView.findViewById(R.id.video_imageId);
            numtext= (TextView) itemView.findViewById(R.id.video_numtextId);
            collectimagbutton= (ImageButton) itemView.findViewById(R.id.collectId);
            shareimagbutton= (ImageButton) itemView.findViewById(R.id.shareId);
            frametext= (TextView) itemView.findViewById(R.id.frametextviewId);

        }
    }
}
