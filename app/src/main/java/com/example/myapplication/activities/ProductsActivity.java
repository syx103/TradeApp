package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;
import com.example.myapplication.base.SwipeCloseActivity;

public class ProductsActivity extends SwipeCloseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        ConstraintLayout digital = findViewById(R.id.cl_digital);
        digital.setOnClickListener(this);
        ConstraintLayout book = findViewById(R.id.cl_book);
        book.setOnClickListener(this);
        ConstraintLayout furniture = findViewById(R.id.cl_furniture);
        furniture.setOnClickListener(this);
        ConstraintLayout art = findViewById(R.id.cl_art);
        art.setOnClickListener(this);
        ConstraintLayout drink = findViewById(R.id.cl_drink);
        drink.setOnClickListener(this);
        ConstraintLayout medicine = findViewById(R.id.cl_medicine);
        medicine.setOnClickListener(this);
        ConstraintLayout clean = findViewById(R.id.cl_clean);
        clean.setOnClickListener(this);
        ConstraintLayout life = findViewById(R.id.cl_life);
        life.setOnClickListener(this);
        ConstraintLayout sport = findViewById(R.id.cl_sport);
        sport.setOnClickListener(this);
        ConstraintLayout suit = findViewById(R.id.cl_suit);
        suit.setOnClickListener(this);
        ConstraintLayout toy = findViewById(R.id.cl_toy);
        toy.setOnClickListener(this);
        ConstraintLayout others = findViewById(R.id.cl_others);
        others.setOnClickListener(this);
    }

    public void jumpToMain(View view) {
        onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ProListActivity.class);
        switch (v.getId()) {
            case R.id.cl_digital:
                intent.putExtra("category", "digital");
                startActivity(intent);
                break;
            case R.id.cl_book:
                intent.putExtra("category", "book");
                startActivity(intent);
                break;
            case R.id.cl_furniture:
                intent.putExtra("category", "furniture");
                startActivity(intent);
                break;
            case R.id.cl_art:
                intent.putExtra("category", "art");
                startActivity(intent);
                break;
            case R.id.cl_drink:
                intent.putExtra("category", "drink");
                startActivity(intent);
                break;
            case R.id.cl_medicine:
                intent.putExtra("category", "medicine");
                startActivity(intent);
                break;
            case R.id.cl_clean:
                intent.putExtra("category", "clean");
                startActivity(intent);
                break;
            case R.id.cl_life:
                intent.putExtra("category", "life");
                startActivity(intent);
                break;
            case R.id.cl_sport:
                intent.putExtra("category", "sport");
                startActivity(intent);
                break;
            case R.id.cl_suit:
                intent.putExtra("category", "suit");
                startActivity(intent);
                break;
            case R.id.cl_toy:
                intent.putExtra("category", "toy");
                startActivity(intent);
                break;
            case R.id.cl_others:
                intent.putExtra("category", "others");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
