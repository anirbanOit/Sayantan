package com.oit.san.retrofitpost.data.remote;

/**
 * Created by OPTLPTP119 on 06-09-2017.
 */

import com.oit.san.retrofitpost.data.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("/addUser")
    Call<Student> createUser( @Body Student createUserResponse);
    @GET("/users")
    Call<List<Student>> getAllUsers();
}