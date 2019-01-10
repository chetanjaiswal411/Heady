package com.heady.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tax implements Serializable
{

    private String name;

    private float value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
