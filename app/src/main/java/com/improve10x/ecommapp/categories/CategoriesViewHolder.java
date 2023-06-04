package com.improve10x.ecommapp.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommapp.databinding.CategoriesItemBinding;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {

     CategoriesItemBinding binding;
    public CategoriesViewHolder(CategoriesItemBinding categoriesItemBinding) {
        super(categoriesItemBinding.getRoot());
        binding = categoriesItemBinding;
    }
}
