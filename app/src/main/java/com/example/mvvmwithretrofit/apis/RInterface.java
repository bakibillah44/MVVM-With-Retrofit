package com.example.mvvmwithretrofit.apis;

import com.example.mvvmwithretrofit.products_models.AllProductModels;
import com.example.mvvmwithretrofit.products_models.ProductsModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RInterface {

    @GET("products")
    Call<AllProductModels> getAllProducts();

}
