package com.example.myntraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class Men_HomeAdapter extends RecyclerView.Adapter<Men_HomeAdapter.ViewHolder> {

    //Context context;
    List<SliderItem> arrayList;
    public ViewPager2 viewPager2;

    public Men_HomeAdapter(List<SliderItem> arrayList, ViewPager2 viewPager2) {
        this.arrayList = arrayList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public Men_HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.men_home_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Men_HomeAdapter.ViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(arrayList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.relat1);

        }
    }
}
