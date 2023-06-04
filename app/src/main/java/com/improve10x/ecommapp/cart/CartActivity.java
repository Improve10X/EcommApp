package com.improve10x.ecommapp.cart;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.ecommapp.BaseActivity;
import com.improve10x.ecommapp.databinding.ActivityCartBinding;
import com.improve10x.ecommapp.models.CartProductLists;
import com.improve10x.ecommapp.models.CartProducts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseActivity {
    private ActivityCartBinding binding;
    private ArrayList<CartProductLists> cartProductLists = new ArrayList<>();
    private CartAdapter cartAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchCarts();
        setUpCartAdapter();
        setUpCartRv();
    }

    private void fetchCarts() {
        Call<CartProducts> call = fakeApiService.fetchCarts();
        call.enqueue(new Callback<CartProducts>() {
            @Override
            public void onResponse(Call<CartProducts> call, Response<CartProducts> response) {
                CartProducts cartProducts = response.body();
                cartAdapter.setCartData(cartProducts.cartProductLists);
                Toast.makeText(CartActivity.this, "Success get load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CartProducts> call, Throwable t) {
                Toast.makeText(CartActivity.this, "Failed to loaded", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setUpCartAdapter() {
        cartAdapter = new CartAdapter();
        cartAdapter.setCartData(cartProductLists);
    }

    private void setUpCartRv() {
        binding.cartRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRv.setAdapter(cartAdapter);
    }
}