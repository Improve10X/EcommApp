package com.improve10x.ecommapp.productsList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommapp.databinding.ProductsItemBinding;
import com.improve10x.ecommapp.models.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private List<Products> products;
    private String imageUrl;

    OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }


    void setProductsData(List<Products> products) {
        this.products = products;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductsItemBinding binding = ProductsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductsViewHolder productsViewHolder = new ProductsViewHolder(binding);
        return productsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Products product = products.get(position);
        holder.binding.productTitleTxt.setText(product.getTitle());
        holder.binding.priceTxt.setText(String.valueOf(product.getPrice()));
        Picasso.get().load(product.getImageUrl().get(0)).into(holder.binding.productImg);
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
