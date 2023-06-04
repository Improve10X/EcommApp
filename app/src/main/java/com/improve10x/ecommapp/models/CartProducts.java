package com.improve10x.ecommapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CartProducts {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer userId;

    private String date;

    @SerializedName("products")
    public ArrayList<CartProductLists> cartProductLists;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
