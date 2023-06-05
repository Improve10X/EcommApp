package com.improve10x.ecommapp.productsList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;

import com.improve10x.ecommapp.BaseActivity;
import com.improve10x.ecommapp.ProductsDetailsActivity;
import com.improve10x.ecommapp.R;
import com.improve10x.ecommapp.databinding.ActivityProductsBinding;
import com.improve10x.ecommapp.models.Products;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private ArrayList<Products> products = new ArrayList<>();
    private ActivityProductsBinding binding;
    private ProductsAdapter productsAdapter;
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getIntent().hasExtra("category")){
            categoryName = getIntent().getStringExtra("category");
        }
        getSupportActionBar().setTitle("Products");
        fetchProducts();
        setUpProductAdapter();
        setUpProductsRv();
    }

    private void fetchProducts() {
        Call<List<Products>> call =fakeApiService.getProducts(categoryName);
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> productsList = response.body();
                productsAdapter.setProductsData(productsList);
                Toast.makeText(ProductsActivity.this, "Successfully get data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpProductAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setProductsData(products);
        productsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(int productsId) {
                Intent intent = new Intent(ProductsActivity.this, ProductsDetailsActivity.class);
                intent.putExtra("products",productsId);
                startActivity(intent);
            }
        });

    }

    private void setUpProductsRv() {
        binding.productsRv.setLayoutManager(new GridLayoutManager(this,2));
        binding.productsRv.setAdapter(productsAdapter);
    }
}


