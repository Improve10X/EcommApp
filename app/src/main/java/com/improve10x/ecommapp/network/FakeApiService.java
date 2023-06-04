package com.improve10x.ecommapp.network;

import com.improve10x.ecommapp.models.CartProductLists;
import com.improve10x.ecommapp.models.CartProducts;
import com.improve10x.ecommapp.models.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET("products/categories")
    Call<List<String>> getCategories();

    @GET("products/category/{categoryName}")
    Call<List<Products>> getProducts(@Path("categoryName")String Categories);

    @GET("products/{productId}")
    Call<Products> getProductDetails(@Path("productId")int productId);

    @GET("carts/1?userId=1")
    Call<CartProducts> fetchCarts();
}
