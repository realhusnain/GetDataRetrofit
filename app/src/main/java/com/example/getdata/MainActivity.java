package com.example.getdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RetroApi retroApi;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RetroApi retroApi = retrofit.create(RetroApi.class);

        Call<List<StoreData>> call = retroApi.getStoreData();


        call.enqueue(new Callback<List<StoreData>>() {
            @Override
            public void onResponse(Call<List<StoreData>> call, Response<List<StoreData>> response) {
                if (response.body().size() > 0) {
                    List<StoreData> storeData = response.body();
                    AdapterClass adapterClass = new AdapterClass(MainActivity.this, storeData);
                    recyclerView.setAdapter(adapterClass);
                } else {
                    Toast.makeText(MainActivity.this, "List empty", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<StoreData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
