package com.improve10x.ecommapp.categories;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommapp.databinding.CategoriesItemBinding;
import com.improve10x.ecommapp.models.Categories;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter <CategoriesViewHolder>{

    public List<Categories> categories;

    public OnItemActionListener onItemActionListener;

    public void setCategoriesData(List<Categories> categories){
        this.categories = categories;
        notifyDataSetChanged();

    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener){
        this.onItemActionListener = onItemActionListener;

    }
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemBinding binding =CategoriesItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(binding);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
      Categories category = categories.get(position);
      holder.binding.titleTxt.setText(category.getName());
      holder.binding.getRoot().setOnClickListener(v -> {
          onItemActionListener.onClick(category.getId());
      });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
