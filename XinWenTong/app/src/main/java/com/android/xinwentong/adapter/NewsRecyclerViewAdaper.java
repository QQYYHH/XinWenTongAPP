package com.android.xinwentong.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.xinwentong.R;
import com.android.xinwentong.entity.ItemCenterPicNews;

import java.util.List;

public class NewsRecyclerViewAdaper extends RecyclerView.Adapter<NewsRecyclerViewAdaper.ViewHolder> {
    private List<ItemCenterPicNews> list;

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
    public NewsRecyclerViewAdaper(List<ItemCenterPicNews> list) {
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_center_pic_news,
                parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
