package com.heady.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class RankingProduct implements Serializable
{
    private int id;

    @SerializedName(value = "count",alternate = {"view_count","order_count","shares"})
    private  String count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
