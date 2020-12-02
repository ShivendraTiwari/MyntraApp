package com.example.myntraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.ViewHolder> {

    Context context;
    List<TshirtApparel2SelectModel> arrayList;

    public AddToCartAdapter(Context context, List<TshirtApparel2SelectModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_view_add_to_cart, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //        byte[] encodeByte = Base64.decode(arrayList.get(position).getImage().toString(), Base64.DEFAULT);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
//        Drawable d = new BitmapDrawable(bitmap);
        // holder.image.setImageResource(Integer.parseInt(d.toString()));
        //   holder.image.setImageResource(Integer.parseInt(arrayList.get(position).getImage()));
        holder.brandName.setText(arrayList.get(position).getBrandName());
        holder.tshirtName.setText(arrayList.get(position).getTshirtName());
        holder.discount.setText(arrayList.get(position).getDiscount());
        holder.price.setText(arrayList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //    ImageView image;
        TextView brandName;
        TextView tshirtName;
        TextView price;
        TextView discount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // image = itemView.findViewById(R.id.image2);
            brandName = itemView.findViewById(R.id.text1);
            tshirtName = itemView.findViewById(R.id.text2);
            price = itemView.findViewById(R.id.text3);
            discount = itemView.findViewById(R.id.text4);
        }
    }
}
