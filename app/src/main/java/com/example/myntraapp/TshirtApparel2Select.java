package com.example.myntraapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TshirtApparel2Select extends AppCompatActivity {

    private static final int REQ = 0;
    RelativeLayout relat3;
    ImageView image1;
    TextView brand;
    TextView tshirt;
    TextView discount1;
    TextView newPrice1;
    TextView oldPrice1;
    TextView price1;
    String image;
    String brandName;
    String tshirtName;
    String price;
    String discount;
    String productId = "";
    RelativeLayout addToBag;
    TextView priceList;
    long key = 0;
    TshirtApparel2SelectModel model;
    DatabaseReference newRef;
    List<TshirtApparel2SelectModel> arrayList;
    TextView a, b, c, d;
    Button btn;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirt_apparel2_select);
        final Intent intent = getIntent();
        //   int key = intent.getIntExtra("fngn", 3);
        image1 = findViewById(R.id.image1);
        brand = findViewById(R.id.text1);
        tshirt = findViewById(R.id.text2);
        discount1 = findViewById(R.id.text4);
        addToBag = findViewById(R.id.addToBag);
        price1 = findViewById(R.id.text3);
        model = new TshirtApparel2SelectModel(brandName, tshirtName, discount, price);
        newRef = FirebaseDatabase.getInstance().getReference().child("Products");
        addToBag.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addingToCartList();

                Intent intent = new Intent(TshirtApparel2Select.this, AddToCart.class);
                startActivity(intent);
                // retrieveData();

            }
        });

    }

    private void addingToCartList() {

        //inserting data
        arrayList = new ArrayList();

        //  InputStream is = new URL(String.valueOf(R.drawable.adidas)).openStream();
//        Bitmap bitMap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.adidas);
//        //   Bitmap bitMap = BitmapFactory.decodeStream(is);
//        Log.d("sdjs", "sd" + bitMap.toString());
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitMap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
//        byte[] b = baos.toByteArray();
//        String encodedImage = Base64.encodeToString(b, Base64.NO_WRAP);
//        model.setImage(encodedImage);

        model.setBrandName(brand.getText().

                toString().

                trim());
        model.setDiscount(tshirt.getText().

                toString().

                trim());
        model.setTshirtName(discount1.getText().

                toString().

                trim());
        model.setPrice(price1.getText().

                toString().

                trim());

        // newRef.push().setValue(model);
        newRef.setValue(model);

        Log.d("dkf==============================l", "f");


        Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        //newRef.child(String.valueOf(key + 1)).setValue(model);
        newRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //       arrayList.clear();
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    TshirtApparel2SelectModel modelCreateGroup = dataSnapshot1.getValue(TshirtApparel2SelectModel.class);
//                    Log.d("testdata", "Generated key: " + modelCreateGroup.getBrandName()
//                            + modelCreateGroup.getDiscount() + modelCreateGroup.getPrice() + modelCreateGroup.getTshirtName());
//                    arrayList.add(modelCreateGroup);

                if (dataSnapshot.exists()) {
                     key = (dataSnapshot.getChildrenCount());
                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(TshirtApparel2Select.this, "Not applied" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}

