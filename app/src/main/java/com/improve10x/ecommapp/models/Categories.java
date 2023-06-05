package com.improve10x.ecommapp.models;

import com.google.gson.annotations.SerializedName;

public class Categories {

    private Integer id;

    private String name;

    @SerializedName("image")

    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
