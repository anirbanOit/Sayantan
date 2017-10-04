package com.oit.san.retrofitpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;

import com.oit.san.retrofitpost.data.model.Student;
import com.oit.san.retrofitpost.data.remote.APIService;
import com.oit.san.retrofitpost.data.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIService mAPIService;
    List userList = new ArrayList();
    private RecyclerView oRecycler;
    private RecyclerView.LayoutManager oLayoutManager;
    private MyRecyclerAdapter oRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAPIService = ApiUtils.getAPIService();
        String firstName="Sayantan";
        String lastName="Choudhury";
        String gender="Male";
        String dob="28/12/1992";
        String photo="abcd test base64 string";
        String department="Android";
        sendPost(firstName, lastName, gender, dob, photo, department);

        getUserList();
    }
    public void sendPost(String firstName, String lastName, String gender, String dob, String photo, String department){
        Student oStudent = new Student();
        oStudent.setFirstName(firstName);
        oStudent.setLastName(lastName);
        oStudent.setGender(gender);
        oStudent.setDob(dob);
        oStudent.setPhoto(photo);
        oStudent.setDept(department);
        Log.d("san","No error");

        mAPIService.createUser(oStudent).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(retrofit2.Call<Student> call, Response<Student> response) {
                Log.d("san","Value inserted");
            }

            @Override
            public void onFailure(retrofit2.Call<Student> call, Throwable t) {

            }
        });
    }

    public void getUserList(){
        Call<List<Student>> call = mAPIService.getAllUsers();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                List<Student> userList =  response.body();
               /*
                for(Student oStudent:userList){
                    String firstName=oStudent.getFirstName();
                    String lastName=oStudent.getLastName();
                    String department=oStudent.getDept();
                    String dob=oStudent.getDob();
                    String gender=oStudent.getGender();
                    String photo=oStudent.getPhoto();

                    userList.add(oStudent);
                }*/

                oRecycler = (RecyclerView)findViewById(R.id.myReycler);
                oLayoutManager = new LinearLayoutManager(MainActivity.this);
                oRecycler.setLayoutManager(oLayoutManager);
                oRecycler.setHasFixedSize(true);

               oRecyclerAdapter = new MyRecyclerAdapter(userList);
                oRecycler.setAdapter(oRecyclerAdapter);
            }




            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }
        });
    }
}
