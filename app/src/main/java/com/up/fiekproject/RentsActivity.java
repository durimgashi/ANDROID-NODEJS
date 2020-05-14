package com.up.fiekproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.up.fiekproject.Model.Car;
import com.up.fiekproject.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CarRecyclerViewAdapter rentsRecyclerViewAdapter;
    private ApiService apiService;
    List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rents);


        recyclerView = findViewById(R.id.rentsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.48:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        Integer userId = bundle.getInt("userId");

        getRents(userId);
    }

    public void getRents(Integer userId){
        Call<List<Car>> call = apiService.getRents(userId);
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                List<Car> cars = response.body();
                rentsRecyclerViewAdapter = new CarRecyclerViewAdapter(RentsActivity.this, cars);
                recyclerView.setAdapter(rentsRecyclerViewAdapter);
                rentsRecyclerViewAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "YESSSSS", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "NOOOOO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
