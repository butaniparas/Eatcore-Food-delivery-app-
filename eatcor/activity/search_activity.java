package com.example.eatcor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.eatcor.R;
import com.example.eatcor.fragment.delivery;
import com.example.eatcor.fragment.dining;

public class search_activity extends AppCompatActivity {
    FrameLayout framelayout;
    TextView tv_delivery, tv_dining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        framelayout = findViewById(R.id.framelayout);
        tv_dining = findViewById(R.id.tv_dining);
        tv_delivery = findViewById(R.id.tv_delivery);

        tv_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.framelayout, new delivery());
                transaction.commit();


            }
        });
        tv_dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragment = getSupportFragmentManager();
                FragmentTransaction transaction = fragment.beginTransaction();
                transaction.add(R.id.framelayout, new dining());
                transaction.commit();
            }
        });
    }
}