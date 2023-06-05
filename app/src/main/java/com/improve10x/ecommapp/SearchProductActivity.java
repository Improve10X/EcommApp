package com.improve10x.ecommapp;

import android.os.Bundle;

import com.improve10x.ecommapp.databinding.ActivitySearchBinding;

import java.util.ArrayList;

public class SearchProductActivity extends BaseActivity {
    private ActivitySearchBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}