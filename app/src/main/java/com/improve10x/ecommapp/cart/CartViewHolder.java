package com.improve10x.ecommapp.cart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommapp.databinding.CartItemBinding;

public class CartViewHolder extends RecyclerView.ViewHolder {
    CartItemBinding binding;
    public CartViewHolder(CartItemBinding cartItemBinding) {
        super(cartItemBinding.getRoot());

        binding = cartItemBinding;
    }
}
