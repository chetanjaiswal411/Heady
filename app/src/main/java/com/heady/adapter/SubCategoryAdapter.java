package com.heady.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heady.R;
import com.heady.util.SharedPreferenceManager;
import com.heady.model.Categories;
import com.heady.ui.ProductActivity;
import com.heady.ui.SubCategoryActivity;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {

    private int listItemLayout;
    private static ArrayList<Categories> categoriesArrayList;
    private static Context ctx;
    private static ArrayList<Integer> categoryPosList;

    public SubCategoryAdapter(int layoutId, ArrayList<Categories> categoriesArrayList,ArrayList<Integer> categoryPosList,Context ctx) {
        listItemLayout = layoutId;
        this.categoriesArrayList = categoriesArrayList;
        this.categoryPosList = categoryPosList;
        this.ctx= ctx;
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList == null ? 0 : categoriesArrayList.size();
    }

    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        SubCategoryAdapter.ViewHolder myViewHolder = new SubCategoryAdapter.ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final SubCategoryAdapter.ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        item.setText(categoriesArrayList.get(listPosition).getName());
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.textView_sub_category_name);
        }
        @Override
        public void onClick(View view) {
            SharedPreferenceManager.writeInteger(ctx,"cat_pos",categoryPosList.get(getLayoutPosition()));

            if(!categoriesArrayList.get(getLayoutPosition()).getChild_categories().isEmpty())
            {
                ((Activity)ctx).finish();
                Intent  intent = new Intent(ctx,SubCategoryActivity.class);
                ctx.startActivity(intent);
            }
            else
            {
                Intent  intent = new Intent(ctx,ProductActivity.class);
                ctx.startActivity(intent);
            }
        }
    }
}

