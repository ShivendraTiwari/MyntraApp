package com.example.myntraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Men_Home_TopWear extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Men__top_wearModel> arrayList;
    Men__top_wearAdapter adapter;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men__home__top_wear);

        Intent intent = getIntent();
        recyclerView = findViewById(R.id.recycler1);
        image=findViewById(R.id.image1);
        image.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Men_Home_TopWear.this,TshirtApparel1.class);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        arrayList = new ArrayList();

        arrayList.add(new Men__top_wearModel(R.drawable.tmlogo, R.drawable.men2, "Classic WFH Essentials", "T-Shirts"));
        arrayList.add(new Men__top_wearModel(R.drawable.klogo, R.drawable.chrishemsworth, "For Your Comfort At Home", "T-Shirts"));
        arrayList.add(new Men__top_wearModel(R.drawable.pepelogo, R.drawable.wrangler, "Cozy & Comfortable", "T-Shirts"));
        arrayList.add(new Men__top_wearModel(R.drawable.curtainlogo, R.drawable.tshirt, "Mesmerizing Colors & Prints", "T-Shirts"));
        arrayList.add(new Men__top_wearModel(R.drawable.adidas, R.drawable.male1, "Monochromes", "T-Shirts"));

        adapter = new Men__top_wearAdapter(getBaseContext(), arrayList);
        recyclerView.setAdapter(adapter);
    }
}