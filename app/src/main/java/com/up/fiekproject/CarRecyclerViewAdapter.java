package com.up.fiekproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.up.fiekproject.Model.Car;

import java.util.List;

public class CarRecyclerViewAdapter extends RecyclerView.Adapter<CarRecyclerViewAdapter.ViewHolder> {

    Context context;
    private List<Car> carList;

    public CarRecyclerViewAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_item, viewGroup, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = carList.get(position);
        String pic = car.getPicturePath();
        String imgPath = "@mipmap/" + pic.split("\\.")[0];
        String carPrice = "$" + car.getPrice();

        holder.carImage.setImageResource(context.getResources().getIdentifier(imgPath, null, context.getPackageName()));
        holder.brand.setText(car.getProductName());
        holder.type.setText(car.getPlatform());
        holder.price.setText(carPrice);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView carImage;
        public TextView brand;
        public TextView type;
        public TextView price;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;
            carImage = itemView.findViewById(R.id.carImage);
            brand= itemView.findViewById(R.id.brand);
            type= itemView.findViewById(R.id.type);
            price= itemView.findViewById(R.id.price);
        }
    }
}
