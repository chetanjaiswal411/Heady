package com.heady.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import com.google.gson.Gson;
import com.heady.adapter.ProductAdapter;
import com.heady.R;
import com.heady.util.SharedPreferenceManager;
import com.heady.model.Data;

public class ProductActivity extends AppCompatActivity
{
    private RecyclerView productRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Data data;
    private int pos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Product");
        productRecyclerView = findViewById(R.id.recyclerView_product);
        productRecyclerView.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        productRecyclerView.setLayoutManager(layoutManager);
        Gson gson= new Gson();
        data = gson.fromJson(SharedPreferenceManager.readString(ProductActivity.this,"response",""),Data.class);
        pos = SharedPreferenceManager.readInteger(this,"cat_pos",-1);
        ProductAdapter productAdapter = new ProductAdapter(R.layout.item_product, data.getCategories().get(pos).getProducts(),this);
        productRecyclerView.setItemAnimator(new DefaultItemAnimator());
        productRecyclerView.setAdapter(productAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

}
