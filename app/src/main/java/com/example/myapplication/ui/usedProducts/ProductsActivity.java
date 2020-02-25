package com.example.myapplication.ui.usedProducts;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.ui.MainActivity;
import com.example.myapplication.ui.productList.ProductListActivity;

public class ProductsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        if (Build.VERSION.SDK_INT > 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void jumpToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ProductListActivity.class);
        switch (v.getId()) {
            case R.id.cl_digital:
                intent.putExtra("category", "digital");
                break;
            case R.id.cl_book:
                intent.putExtra("category", "book");
                break;
            case R.id.cl_furniture:
                intent.putExtra("category", "furniture");
                break;
            case R.id.cl_art:
                intent.putExtra("category", "art");
                break;
            case R.id.cl_drink:
                intent.putExtra("category", "drink");
                break;
            case R.id.cl_medicine:
                intent.putExtra("category", "medicine");
                break;
            case R.id.cl_clean:
                intent.putExtra("category", "clean");
                break;
            case R.id.cl_life:
                intent.putExtra("category", "life");
                break;
            case R.id.cl_sport:
                intent.putExtra("category", "sport");
                break;
            case R.id.cl_suit:
                intent.putExtra("category", "suit");
                break;
            case R.id.cl_toy:
                intent.putExtra("category", "toy");
                break;
            case R.id.cl_others:
                intent.putExtra("category", "others");
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
