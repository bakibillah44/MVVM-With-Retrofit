package com.example.mvvmwithretrofit.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmwithretrofit.R;
import com.example.mvvmwithretrofit.products_models.AllProductModels;
import com.example.mvvmwithretrofit.products_models.ProductsModels;

import java.util.List;

public class RetrofitProductAdapter extends RecyclerView.Adapter<RetrofitProductAdapter.ViewHolder> {

    List<ProductsModels> maineModelArrayList;
    Activity activity;

    public RetrofitProductAdapter(List<ProductsModels> maineModelArrayList, Activity activity) {
        this.maineModelArrayList = maineModelArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.txtTitle.setText(maineModelArrayList.get(position).getTitle());
        holder.txtDescription.setText(maineModelArrayList.get(position).getDescription());
        holder.txtPrice.setText(maineModelArrayList.get(position).getPrice()+" $");
        holder.txtDiscount.setText(maineModelArrayList.get(position).getDiscountPercentage()+"");
        holder.txtBrand.setText(maineModelArrayList.get(position).getBrand());
        holder.txtStock.setText(maineModelArrayList.get(position).getStock()+"");
        holder.txtCategory.setText(maineModelArrayList.get(position).getCategory());
        holder.ratingBar.setRating((float) maineModelArrayList.get(position).getRating());




        Glide.with(holder.imgThumbnail.getContext())
                .load(maineModelArrayList.get(position)
                        .getThumbnail()).into(holder.imgThumbnail);


        /*holder.secondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra("_id", maineModelArrayList.get(position).getId()+"");
                activity.startActivity(intent);
                Toast.makeText(view.getContext(), "click on item: " + maineModelArrayList.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {

        if (this.maineModelArrayList!=null){
            return this.maineModelArrayList.size();
        }else {
            return 0;
        }
    }

    public void setMaineModelArrayList(List<ProductsModels> allProductModels){
        this.maineModelArrayList = allProductModels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtDescription, txtPrice, txtDiscount, txtBrand, txtStock, txtCategory,
                txtTotal,txtSkip,txtLimit;
        RatingBar ratingBar;
        ImageView imgThumbnail;
        LinearLayout secondLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtDiscount = itemView.findViewById(R.id.txtDiscount);
            txtBrand = itemView.findViewById(R.id.txtBrand);
            txtStock = itemView.findViewById(R.id.txtStock);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtTotal = itemView.findViewById(R.id.txtTotal);
            txtSkip = itemView.findViewById(R.id.txtSkip);
            txtLimit = itemView.findViewById(R.id.txtLimit);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
            //secondLayout = itemView.findViewById(R.id.secondLayout);


        }
    }
}
