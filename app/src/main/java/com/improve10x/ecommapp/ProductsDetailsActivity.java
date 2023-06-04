package com.improve10x.ecommapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.improve10x.ecommapp.cart.CartActivity;
import com.improve10x.ecommapp.databinding.ActivityProductsDetailsBinding;
import com.improve10x.ecommapp.models.Products;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsDetailsActivity extends BaseActivity {

   private ActivityProductsDetailsBinding binding;
   int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("ProductDetails");
        if (getIntent().hasExtra("products")){
            productId = getIntent().getIntExtra("products",0);
        }
        fetchProductDetails();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_details_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.product_details_menu){
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void fetchProductDetails() {
        Call<Products> call = fakeApiService.getProductDetails(productId);
        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                Products products = response.body();
                binding.setProduct(products);
                Toast.makeText(ProductsDetailsActivity.this, "Successfully loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Toast.makeText(ProductsDetailsActivity.this, "Failed to loaded", Toast.LENGTH_SHORT).show();

            }
        });

    }
}