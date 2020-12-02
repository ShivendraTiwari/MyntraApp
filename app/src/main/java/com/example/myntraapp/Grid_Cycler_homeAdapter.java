package com.example.myntraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Grid_Cycler_homeAdapter extends BaseAdapter {

    private Context context;
    GridView gridView;
    //List<Grid_Cycler_homeModel> arrayList4;

    public Grid_Cycler_homeAdapter(Context context) {
        this.context = context;
      //  this.arrayList4 = arrayList4;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
//        ImageView imageView;
////        TextView text;
////        view = LayoutInflater.from(context).inflate(R.layout.grid_view, parent, false);
////        ImageView image = view.findViewById(R.id.profile_image);
////        image.setImageResource(arrayList4.get(position).getImage());
////        text = view.findViewById(R.id.text1);
////        text.setText(arrayList4.get(position).getText());
////        gridView.setLayoutParams(new GridLayout.LayoutParams(100,100));
////       gridView.setScaleType(gridView.ScaleType.CENTER_CROP);
////        gridView .setPadding(8, 8, 8, 8);
////        return view;

        ImageView imageView;

        if (view == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) view;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.kurta,
            R.drawable.tshirt,
            R.drawable.trackpant,
            R.drawable.jewelley,
            R.drawable.shoe,
            R.drawable.headphone,
            R.drawable.watch,
            R.drawable.jeans,
            R.drawable.women,
            R.drawable.bath,
            R.drawable.gold,
            R.drawable.womendress,
    };
    }
