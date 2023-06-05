package com.improve10x.ecommapp.network;

import com.improve10x.ecommapp.models.CartProductLists;
import com.improve10x.ecommapp.models.CartProducts;
import com.improve10x.ecommapp.models.Categories;
import com.improve10x.ecommapp.models.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeApiService {

    @GET("api/v1/categories")
    Call<List<Categories>> getCategories();

    @GET("api/v1/products/")
    Call<List<Products>> getProducts(@Query("categoryId") String categoryId);

    @GET("api/v1/products/4")
    Call<Products> getProductDetails();

    @GET("carts/1?userId=1")
    Call<CartProducts> fetchCarts();
}
