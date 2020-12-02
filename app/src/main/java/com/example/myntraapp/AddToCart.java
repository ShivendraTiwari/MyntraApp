package com.example.myntraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddToCart extends AppCompatActivity {

    DatabaseReference newRef;
    List<TshirtApparel2SelectModel> arrayList;
    RecyclerView recyclerView;
    AddToCartAdapter adapter;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        // Log.d("Val", "==============================================================");
        Intent intent = getIntent();
        recyclerView = findViewById(R.id.recycler_view);
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
//                bottomSheetDialog.show(getSupportFragmentManager(), "ModalBottomSheet");
                Intent intent1 = new Intent(AddToCart.this, OTPGeneration.class);
                startActivity(intent1);
            }
        });
        Toast.makeText(AddToCart.this, "Retrieving Cart successfully", Toast.LENGTH_SHORT).show();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        arrayList = new ArrayList();
        newRef = FirebaseDatabase.getInstance().getReference().child("Products");
        // image1 = findViewById(R.id.image2);
        newRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //  for (DataSnapshot messageSnapshot : snapshot.getChildren())

                arrayList.clear();
                TshirtApparel2SelectModel tshirtApparel2SelectModel1 = snapshot.getValue(TshirtApparel2SelectModel.class);
                // Log.d("dfd", "sdsdsd" + tshirtApparel2SelectModel1.getImage());
                // String image = snapshot.child("image").getValue().toString();
                Toast.makeText(AddToCart.this, "Added successfully", Toast.LENGTH_SHORT).show();
//                    Glide.with(getApplicationContext()).load(R.drawable.adidas).apply(RequestOptions.signatureOf(new CenterCrop()))
//                            .into(image1);
                arrayList.add(tshirtApparel2SelectModel1);
                if (!arrayList.isEmpty()) {
                    // ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
                    adapter = new AddToCartAdapter(getApplicationContext(), arrayList);
                    recyclerView.setAdapter(adapter);
                }
                Toast.makeText(AddToCart.this, "Retrieving data successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Toast.makeText(AddToCart.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}