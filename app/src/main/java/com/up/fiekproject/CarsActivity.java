package com.up.fiekproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.up.fiekproject.Model.Car;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CarRecyclerViewAdapter carRecyclerViewAdapter;
    private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        recyclerView = findViewById(R.id.productsRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IPja.IP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        getCars();
    }
    public void getCars(){

        Call<List<Car>> call = apiService.getCars();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                List<Car> cars = response.body();
                carRecyclerViewAdapter = new CarRecyclerViewAdapter(CarsActivity.this, cars);
                recyclerView.setAdapter(carRecyclerViewAdapter);
                carRecyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "NOOOOO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
