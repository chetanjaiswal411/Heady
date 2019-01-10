package com.heady.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Categories implements Serializable
{
    private int id;
    private String name;

    private ArrayList<Products> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
}
