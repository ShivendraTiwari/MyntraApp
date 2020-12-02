package com.example.myntraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycle_horizontal1_homeAdapter extends RecyclerView.Adapter<Recycle_horizontal1_homeAdapter.ViewHolder> {

    Context context;
    List<Recycler_horizontal1_homeModel> arrayList;

    public Recycle_horizontal1_homeAdapter(Context context, List<Recycler_horizontal1_homeModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Recycle_horizontal1_homeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view2_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_horizontal1_homeAdapter.ViewHolder holder, int position) {
        holder.image1.setImageResource(arrayList.get(position).getImage1());
        holder.image2.setImageResource(arrayList.get(position).getImage2());
        holder.img_title.setText(arrayList.get(position).getImg_title());
        holder.img_description.setText(arrayList.get(position).getImg_description());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;
        ImageView image2;
        TextView img_title;
        TextView img_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.icon);
            img_title = itemView.findViewById(R.id.img_title);
            img_description = itemView.findViewById(R.id.img_description);
        }
    }
}
