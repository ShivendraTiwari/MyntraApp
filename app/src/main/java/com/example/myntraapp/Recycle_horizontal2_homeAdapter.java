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

public class Recycle_horizontal2_homeAdapter extends RecyclerView.Adapter<Recycle_horizontal2_homeAdapter.ViewHolder> {

    Context context;
    List<Recycle_horizontal2_homeModel> arrayList3;

    public Recycle_horizontal2_homeAdapter(Context context, List<Recycle_horizontal2_homeModel> arrayList3) {
        this.context = context;
        this.arrayList3 = arrayList3;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler3_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle_horizontal2_homeAdapter.ViewHolder holder, int position) {
        holder.image1.setImageResource(arrayList3.get(position).getImage1());
        holder.icon.setImageResource(arrayList3.get(position).getIcon());
        holder.img_title.setText(arrayList3.get(position).getImg_title());
        holder.img_description.setText(arrayList3.get(position).getImg_description());
    }

    @Override
    public int getItemCount() {
        return arrayList3.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;
        ImageView icon;
        TextView img_title;
        TextView img_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            icon = itemView.findViewById(R.id.icon);
            img_title = itemView.findViewById(R.id.img_title);
            img_description = itemView.findViewById(R.id.img_description);
        }
    }
}
