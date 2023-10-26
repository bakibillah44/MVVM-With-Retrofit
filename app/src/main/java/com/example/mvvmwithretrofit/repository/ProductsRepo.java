package com.example.mvvmwithretrofit.repository;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmwithretrofit.apis.RInterface;
import com.example.mvvmwithretrofit.apis.RetrofitInstance;
import com.example.mvvmwithretrofit.products_models.AllProductModels;
import com.example.mvvmwithretrofit.products_models.ProductsModels;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRepo extends ViewModel {



    public MutableLiveData<List<ProductsModels>> allProductsList;
    List<ProductsModels> arrayList= new ArrayList<>();
    public ProductsRepo(){
        allProductsList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductsModels>> getAllProductsList() {
        return allProductsList;
    }


    public void makeApiCall(){


        RInterface rInterface = RetrofitInstance.getProducts().create(RInterface.class);
        Call<AllProductModels> call = rInterface.getAllProducts();
        call.enqueue(new Callback<AllProductModels>() {
            @Override
            public void onResponse(Call<AllProductModels> call, Response<AllProductModels> response) {

                if (response.isSuccessful() && response.body()!=null ) {
                    arrayList.addAll(response.body().getProducts());
                    Log.e(TAG, "requestHolidaysresponse.size="+response.body().getProducts().get(0).getTitle() );
                    allProductsList.setValue(arrayList);

                }
            }

            @Override
            public void onFailure(Call<AllProductModels> call, Throwable t) {
                allProductsList.postValue(null);
                Log.e("data not found :",t.getMessage().toString());

            }
        });


    }
}
