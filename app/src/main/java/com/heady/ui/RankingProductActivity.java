package com.heady.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import com.google.gson.Gson;
import com.heady.R;
import com.heady.adapter.RankingProductAdapter;
import com.heady.util.SharedPreferenceManager;
import com.heady.model.Categories;
import com.heady.model.Data;
import com.heady.model.RankingProduct;
import java.util.ArrayList;

public class RankingProductActivity extends AppCompatActivity
{
    private RecyclerView rankingProductRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Data data;
    private int pos;
    private String type,typeName;
    private ArrayList<RankingProduct> rankingProductArrayList;
    private ArrayList<Categories> categoriesArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_product);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rankingProductRecyclerView = findViewById(R.id.recyclerView_ranking_product);
        rankingProductRecyclerView.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        rankingProductRecyclerView.setLayoutManager(layoutManager);
        Gson gson= new Gson();
        data = gson.fromJson(SharedPreferenceManager.readString(RankingProductActivity.this,"response",""),Data.class);
        categoriesArrayList= data.getCategories();
        type= SharedPreferenceManager.readString(this,"type","");
        typeName=SharedPreferenceManager.readString(this,"type_name","");

        if(type.equals("0"))
        {
           rankingProductArrayList = data.getRankings().get(0).getRankingProducts();
        }
        else if(type.equals("1"))
        {
            rankingProductArrayList = data.getRankings().get(1).getRankingProducts();
        }
        else
        {
            rankingProductArrayList = data.getRankings().get(2).getRankingProducts();
        }
        setTitle(typeName);
        RankingProductAdapter productAdapter = new RankingProductAdapter(R.layout.item_ranking_product,type, rankingProductArrayList,categoriesArrayList,this);
        rankingProductRecyclerView.setItemAnimator(new DefaultItemAnimator());
        rankingProductRecyclerView.setAdapter(productAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}

