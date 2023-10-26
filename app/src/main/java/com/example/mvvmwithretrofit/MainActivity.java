package com.example.mvvmwithretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmwithretrofit.adapter.RetrofitProductAdapter;
import com.example.mvvmwithretrofit.products_models.AllProductModels;
import com.example.mvvmwithretrofit.products_models.ProductsModels;
import com.example.mvvmwithretrofit.repository.ProductsRepo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<ProductsModels> arrayList;
    RetrofitProductAdapter productAdapter;
    ProductsRepo productsRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new RetrofitProductAdapter(arrayList,this);
        recyclerView.setAdapter(productAdapter);



        productsRepo = new ProductsRepo();
        productsRepo.getAllProductsList().observe(this, new Observer<List<ProductsModels>>() {
            @Override
            public void onChanged(List<ProductsModels> productsModels) {

                productAdapter.setMaineModelArrayList((List<ProductsModels>) productsModels);

                productAdapter.notifyDataSetChanged();

            }
        });


        productsRepo.makeApiCall();



    }
}