package com.example.administrator.secondproject.all_adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.secondproject.R;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public class EditMenuAdapter extends RecyclerView.Adapter<EditMenuAdapter.MyViewHolder> implements View.OnClickListener {
    List<String> list;
    Context context;
    Onitemchangerlistener onitemchangerlistener;

    public EditMenuAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_recylayview, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onClick(View v) {
         if (onitemchangerlistener!=null){
         onitemchangerlistener.setonitemlistener(v,(String)v.getTag());//getTag得到点击的数据
         }
    }

    public interface Onitemchangerlistener {
        void setonitemlistener(View view, String data);
    }

    public void onItemclick(Onitemchangerlistener listenser1) {
        this.onitemchangerlistener = listenser1;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(list.get(position));
        //拿到点击的itemview中的内容
        holder.itemView.setTag(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
                textView = (TextView)itemView.findViewById(R.id.menu_textview);
            }
        }

}
