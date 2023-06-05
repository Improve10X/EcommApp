package com.improve10x.ecommapp.categories;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.ecommapp.BaseActivity;
import com.improve10x.ecommapp.databinding.ActivityCategoriesBinding;
import com.improve10x.ecommapp.models.Categories;
import com.improve10x.ecommapp.productsList.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    private ActivityCategoriesBinding binding;
    private List<Categories> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        fetchCategories();
        setUpCategoriesAdapter();
        setUpCategoriesRcv();
    }

    private void fetchCategories() {
        Call<List<Categories>> call = fakeApiService.getCategories();
        call.enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                List<Categories> categories = response.body();
                categoriesAdapter.setCategoriesData(categories);
                Toast.makeText(CategoriesActivity.this, "Successfully got data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to get", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void setUpCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setCategoriesData(categories);
        categoriesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(int categoryId) {
                Intent intent = new Intent(CategoriesActivity.this,ProductsActivity.class);
                intent.putExtra("categories",categoryId);
                startActivity(intent);
            }
        });
    }

    public void setUpCategoriesRcv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }
}