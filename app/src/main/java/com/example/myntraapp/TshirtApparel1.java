package com.example.myntraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TshirtApparel1 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<TshirtApparel1Model> arrayList;
    TshirtApparel1Adapter adapter;
    RelativeLayout relat1;
    ViewPager2 viewPager2;
    private static int current_Page = 0;
    private static int Num_Pages = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirt_apparel1);
        Intent intent = getIntent();

        recyclerView = findViewById(R.id.recycler1);
        relat1 = findViewById(R.id.relat2sub);


//        relat1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TshirtApparel1.this, TshirtApparel2Select.class);
//                //  intent.putExtra("dnfd",arrayList.get(position).getImage());
//                startActivity(intent);
//                //  Toast.makeText(context, "nndf", Toast.LENGTH_SHORT).show();
//            }
//        });


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new


                GridLayoutManager(getApplicationContext(), 3));
        arrayList = new ArrayList();

        arrayList.add(new

                TshirtApparel1Model(R.drawable.chrishemsworth, "Here&NOW", "Printed Round Neck T-shirt", "Rs 757", "Rs 799", "5% OFF"));
        arrayList.add(new

                TshirtApparel1Model(R.drawable.menstees, "Here&NOW", "Printed Round Neck T-shirt", "Rs 657", "Rs 699", "5% OFF"));
        arrayList.add(new

                TshirtApparel1Model(R.drawable.tshirt, "Here&NOW", "Plain Round Neck T-shirt", "Rs 697", "Rs 799", "5% OFF"));
        arrayList.add(new

                TshirtApparel1Model(R.drawable.wrangler, "Here&NOW", "Printed Collar", "Rs 357", "Rs 599", "5% OFF"));
        arrayList.add(new

                TshirtApparel1Model(R.drawable.male1, "Here&NOW", "Printed Round Button", "Rs 957", "Rs 1099", "5% OFF"));
        arrayList.add(new

                TshirtApparel1Model(R.drawable.jeans, "Here&NOW", "Printed Round Neck", "Rs 957", "Rs 1099", "5% OFF"));

        adapter = new

                TshirtApparel1Adapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);
    }
}