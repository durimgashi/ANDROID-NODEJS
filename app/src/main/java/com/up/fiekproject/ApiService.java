package com.up.fiekproject;

import com.up.fiekproject.Model.Car;
import com.up.fiekproject.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiService {

    @GET("carsJava")
    Call<List<Car>> getCars();

    @GET("users")
    Call<List<User>> getAllUsers();

    @GET("rentJava/{userId}")
    Call<List<Car>> getRents(@Path("userId") Integer userId);

    @FormUrlEncoded
    @POST("registerPost")
    Call<User> createUser(
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("age") Integer age,
            @Field("city") String city
    );
}
