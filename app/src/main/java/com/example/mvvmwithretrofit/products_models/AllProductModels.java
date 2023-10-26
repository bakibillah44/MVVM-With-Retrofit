package com.example.mvvmwithretrofit.products_models;

import java.util.ArrayList;
import java.util.List;

public class AllProductModels {

    private int total;
    private int skip;
    private int limit;

    private List<ProductsModels> products;

    public AllProductModels(int total, int skip, int limit, ArrayList<ProductsModels> products) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }

    public List<ProductsModels> getProducts() {
        return products;
    }
}
