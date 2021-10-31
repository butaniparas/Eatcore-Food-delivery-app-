package com.example.eatcor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatcor.activity.profile_activity;
import com.example.eatcor.activity.search_activity;
import com.example.eatcor.rec_pureveg.adapter;
import com.example.eatcor.rec_pureveg.model;
import com.example.eatcor.top_brands.model_topbrand;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec_pureveg, rev_topbrand;
    EditText edittv_location;
    TextView search_etv;
    ViewFlipper macd_flipper, usp_flipper, domi_flipper, stv_flipper, tpost_flipper;
    ImageView img_profile;
    FrameLayout search_framelay,filter_framelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec_pureveg = findViewById(R.id.rec_pureveg);
        rec_pureveg.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<model> arr = new ArrayList<>();
        model ob1 = new model("Pure Veg");
        arr.add(ob1);

        model ob2 = new model("Fastest Delivery");
        arr.add(ob2);

        model ob3 = new model("Offers");
        arr.add(ob3);

        model ob4 = new model("Ratting");
        arr.add(ob4);

        model ob5 = new model("Cuisines");
        arr.add(ob5);
        rec_pureveg.setAdapter(new adapter(this, arr));

        rev_topbrand = findViewById(R.id.rev_topbrand);
        rev_topbrand.setLayoutManager(new GridLayoutManager(this, 3));
        List<model_topbrand> arr1 = new ArrayList<>();
        model_topbrand tb1 = new model_topbrand("McDonald's", R.drawable.mcdonalds);
        arr1.add(tb1);

        model_topbrand tb2 = new model_topbrand("U.S.Pizza", R.drawable.uspizz);
        arr1.add(tb2);

        model_topbrand tb3 = new model_topbrand("Dominoz's", R.drawable.dominoz);
        arr1.add(tb3);

        model_topbrand tb4 = new model_topbrand("Drizzle's Pizza", R.drawable.drizzlee);
        arr1.add(tb4);

        model_topbrand tb5 = new model_topbrand("PizzaHut", R.drawable.pizzhut);
        arr1.add(tb5);

        model_topbrand tb6 = new model_topbrand("tes Post", R.drawable.teapost);
        arr1.add(tb6);

        rev_topbrand.setAdapter(new com.example.eatcor.top_brands.adapter(this, arr1));


        macd_flipper = findViewById(R.id.macd_flipper);
        int[] macd_image = {R.drawable.macd_1, R.drawable.macd2, R.drawable.macd3,
                R.drawable.macd4, R.drawable.macd5};

        for (int i = 0; i < macd_image.length; i++) {
            macd_showimage(macd_image[i]);
        }

        usp_flipper = findViewById(R.id.usp_flipper);
        int[] usp_image = {R.drawable.us1, R.drawable.us2, R.drawable.us3, R.drawable.us4, R.drawable.us5};
        for (int i = 0; i < usp_image.length; i++) {
            usp_showimage(usp_image[i]);
        }

        domi_flipper = findViewById(R.id.domi_flipper);
        int[] dom_image = {R.drawable.dom1, R.drawable.dom2, R.drawable.dom3, R.drawable.dom4, R.drawable.dom5};
        for (int i = 0; i < dom_image.length; i++) {
            dom_showimage(dom_image[i]);
        }
        stv_flipper = findViewById(R.id.stv_flipper);
        int[] stv_image = {R.drawable.sv1, R.drawable.sv2, R.drawable.sv3, R.drawable.sv4, R.drawable.sv5};
        for (int i = 0; i < stv_image.length; i++) {
            stv_showimage(stv_image[i]);
        }
        tpost_flipper = findViewById(R.id.tpost_flipper);
        int[] tpost_image = {R.drawable.tpost1, R.drawable.tpost2, R.drawable.tpost3, R.drawable.tpost4, R.drawable.tpost5};
        for (int i = 0; i < tpost_image.length; i++) {
            tpost_showimage(tpost_image[i]);
        }

        edittv_location = findViewById(R.id.edittv_location);
        edittv_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        img_profile = findViewById(R.id.img_profile);
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, profile_activity.class);
                startActivity(intent);
            }
        });

        search_framelay = findViewById(R.id.search_framelay);
        search_framelay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, search_activity.class);
                startActivity(i);
            }
        });

    }

    public void macd_showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        macd_flipper.addView(imageView);
        macd_flipper.setFlipInterval(2000);
        macd_flipper.setAutoStart(true);
        macd_flipper.setInAnimation(MainActivity.this, android.R.anim.slide_in_left);
        macd_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void usp_showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        usp_flipper.setAutoStart(true);
        usp_flipper.addView(imageView);
        usp_flipper.setFlipInterval(2000);
        usp_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        usp_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void dom_showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        domi_flipper.setAutoStart(true);
        domi_flipper.addView(imageView);
        domi_flipper.setFlipInterval(2000);
        domi_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        domi_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void stv_showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        stv_flipper.setAutoStart(true);
        stv_flipper.addView(imageView);
        stv_flipper.setFlipInterval(2000);
        stv_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        stv_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void tpost_showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);

        tpost_flipper.setAutoStart(true);
        tpost_flipper.addView(imageView);
        tpost_flipper.setFlipInterval(2000);
        tpost_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        tpost_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}