package com.example.myntraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tooltip.TooltipDrawable;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    RecyclerView horizCir;
    RecyclerView horiz2;
    RecyclerView horiz3;
    GridView gridView;
    LinearLayout linear;
    RoundedImageView roundedImageView;
    CircleImageView circleImageView;
    List<MainActivityModel> arrayList;
    List<Recycler_horizontal1_homeModel> arrayList2;
    List<Recycle_horizontal2_homeModel> arrayList3;
    List<Grid_Cycler_homeModel> arrayList4;
    MainActivityAdapter adapter;
    Recycle_horizontal1_homeAdapter adapter2;
    Recycle_horizontal2_homeAdapter adapter3;
    ViewPager2 viewPager2;
    Grid_Cycler_homeAdapter adapter4;
    //    NavigationView navigationView;
//    DrawerLayout drawerLayout;
//    Toolbar toolbar;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        horizCir = findViewById(R.id.recycler);
        horiz2 = findViewById(R.id.recycler2);
        horiz3 = findViewById(R.id.recycler3);
        gridView = findViewById(R.id.grid_view1);
        roundedImageView = findViewById(R.id.imageView);
        circleImageView = findViewById(R.id.profile_image);

        //actionBar
        // navigationView.bringToFront();


        linear = findViewById(R.id.nikeplay);
        linear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Men_Home.class);
                startActivity(intent);
                //  Toast.makeText(MainActivity.this, "dfdf", Toast.LENGTH_SHORT).show();
            }
        });
        horizCir.setHasFixedSize(true);
        horiz2.setHasFixedSize(true);
        horiz3.setHasFixedSize(true);
        horizCir.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horiz2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horiz3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList3 = new ArrayList();
        arrayList4 = new ArrayList();

        arrayList.add(new MainActivityModel(R.drawable.offers, "OFFERS"));
        arrayList.add(new MainActivityModel(R.drawable.male1, "Men"));
        arrayList.add(new MainActivityModel(R.drawable.circle_female, "Female"));
        arrayList.add(new MainActivityModel(R.drawable.kids, "KIDS"));
        arrayList.add(new MainActivityModel(R.drawable.beauty, "BEAUTY"));
        arrayList.add(new MainActivityModel(R.drawable.home, "HOME"));
        arrayList.add(new MainActivityModel(R.drawable.essential, "ESSENTIALS"));
        arrayList.add(new MainActivityModel(R.drawable.jewelley, "JEWELLERY"));

        adapter = new MainActivityAdapter(getBaseContext(), arrayList);
        horizCir.setAdapter(adapter);

        //ViewPager Start

        viewPager2 = findViewById(R.id.ViewPagerImageSlider);
        final List<SliderItem> sliderItemList = new ArrayList<>();
        sliderItemList.add(new SliderItem(R.drawable.myntraslider1));
        sliderItemList.add(new SliderItem(R.drawable.myntraslider2));
        sliderItemList.add(new SliderItem(R.drawable.myntraslider3));
        sliderItemList.add(new SliderItem(R.drawable.myntraslider4));
        sliderItemList.add(new SliderItem(R.drawable.myntraslider5));
        sliderItemList.add(new SliderItem(R.drawable.myntraslider6));

        viewPager2.setAdapter(new SliderAdapter(sliderItemList, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });


        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);//slide duration 3 sec
            }
        });
        //Recycler2_home start
        arrayList2.add(new Recycler_horizontal1_homeModel(R.drawable.recycler1, R.drawable.ic_favorite, "Pick your Style", "Flat 1000 Off"));
        arrayList2.add(new Recycler_horizontal1_homeModel(R.drawable.recycler4, R.drawable.ic_favorite, "Steal Deals", "Flat 1000 Off"));
        arrayList2.add(new Recycler_horizontal1_homeModel(R.drawable.reccyler2home, R.drawable.ic_favorite, "Top Deals", "Flat 1000 Off"));
        arrayList2.add(new Recycler_horizontal1_homeModel(R.drawable.reccyler3home, R.drawable.ic_favorite, "LIBAS", "Flat 1000 Off"));
        arrayList2.add(new Recycler_horizontal1_homeModel(R.drawable.reccyler6home, R.drawable.ic_favorite, "UNITED COLOR", "Flat 1000 Off"));
        arrayList2.add(new Recycler_horizontal1_homeModel(R.drawable.puma, R.drawable.ic_favorite, "PUMA", "Flat 1000 Off"));

        adapter2 = new Recycle_horizontal1_homeAdapter(getBaseContext(), arrayList2);
        horiz2.setAdapter(adapter2);

        //recycler3_home start
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.pepelogo, R.drawable.wrangler, "Up to 50% Off", "Shop Now"));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.pepelogo, R.drawable.kids, "Up to 40% Off", "On Kids Wear"));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.esteelaud, R.drawable.pepebackground, "Up to 60% Off", "Flat 1000 Off "));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.curtainlogo, R.drawable.curtainback, "Up to 70% Off ", "Flat 1000 Off"));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.adidas, R.drawable.adidasshoe, "Advanced", "On Men's Casual background"));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.rolx, R.drawable.rolex, "Up to 40% Off", " On Home Furnishing"));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.creamlogo, R.drawable.keate, "Up to 60% Off", "Nature's Background"));
        arrayList3.add(new Recycle_horizontal2_homeModel(R.drawable.lotus, R.drawable.nourishcream, "Up to 25% Off", "Eat,Sleep,SkinCare,Repeat"));
        adapter3 = new Recycle_horizontal2_homeAdapter(getBaseContext(), arrayList3);
        horiz3.setAdapter(adapter3);

        //grid view


        GridView gridview = (GridView) findViewById(R.id.grid_view1);
        gridview.setAdapter(new Grid_Cycler_homeAdapter(this));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        arrayList4.add(new Grid_Cycler_homeModel(R.drawable.male1, "sdfn"));
//        adapter4 = new Grid_Cycler_homeAdapter(getApplicationContext(),arrayList4);
//        gridView.setAdapter(adapter4);


//        toolbar = findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);
//        drawerLayout = findViewById(R.id.DrawerLayout);
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
//                R.string.open, R.string.close);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        navigationView = findViewById(R.id.navi_view);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.item1:
//                        Toast.makeText(MainActivity.this, "categories", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.item2:
//                        Toast.makeText(MainActivity.this, "Store", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.item3:
//                        Toast.makeText(MainActivity.this, "Orders", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                drawerLayout.closeDrawers();
//                return false;
//            }
//        });
    }

    private Runnable sliderRunnable = new Runnable() {

        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

}
