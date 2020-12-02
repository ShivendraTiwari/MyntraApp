package com.example.myntraapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TshirtApparel1Adapter extends RecyclerView.Adapter<TshirtApparel1Adapter.ViewHolder> {

    Context context;
    List<TshirtApparel1Model> arrayList;

    public TshirtApparel1Adapter(Context context, List<TshirtApparel1Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tshirt_apparel_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.image1.setImageResource(arrayList.get(position).getImage());
        holder.text1.setText(arrayList.get(position).getText1());
        holder.text2.setText(arrayList.get(position).getText2());
        holder.text3.setText(arrayList.get(position).getText3());
        holder.text4.setText(arrayList.get(position).getText4());
        holder.text5.setText(arrayList.get(position).getText5());

        holder.image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TshirtApparel2Select.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1;
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
        TextView text5;
        public LinearLayout linear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            text4 = itemView.findViewById(R.id.text4);
            text5 = itemView.findViewById(R.id.text5);
            linear = itemView.findViewById(R.id.linear1);


        }
    }
}
