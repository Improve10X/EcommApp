package com.improve10x.ecommapp.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommapp.databinding.CartItemBinding;
import com.improve10x.ecommapp.models.CartProductLists;
import com.improve10x.ecommapp.models.CartProducts;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<CartProductLists> productsList;

    void setCartData(List<CartProductLists> productsList){
        this.productsList = productsList;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding cartItemBinding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        CartViewHolder cartViewHolder = new CartViewHolder(cartItemBinding);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProductLists cartProducts = productsList.get(position);
        holder.binding.productTitleTxt.setText(String.valueOf(cartProducts.getProductId()));
        holder.binding.quantityTxt.setText(String.valueOf(cartProducts.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
