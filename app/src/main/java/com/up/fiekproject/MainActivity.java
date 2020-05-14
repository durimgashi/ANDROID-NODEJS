package com.up.fiekproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.up.fiekproject.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btnSkipRegister;
    private EditText firstName, lastName, username, email, password, age, city;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        age = findViewById(R.id.age);
        city = findViewById(R.id.city);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.48:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

        Button register = findViewById(R.id.register);
        register.setOnClickListener(v -> createUser());

        btnSkipRegister = findViewById(R.id.btnSkipRegister);
        btnSkipRegister.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }

    private void createUser() {
        Call<User> call = apiService.createUser(firstName.getText().toString(),
                lastName.getText().toString(),
                username.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                Integer.parseInt(age.getText().toString()),
                city.getText().toString());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "SUCCES", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_LONG).show();
            }
        });
    }
}
