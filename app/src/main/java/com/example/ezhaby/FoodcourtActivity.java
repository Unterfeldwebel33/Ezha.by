package com.example.ezhaby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ezhaby.Helper.Classes.Home.Adapter.SortAdapter;
import com.example.ezhaby.Helper.Classes.Home.Adapter.SortHelperClass;

import java.util.ArrayList;

public class FoodcourtActivity extends AppCompatActivity {

    RecyclerView sortRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcourt);

        sortRecycler = findViewById(R.id.sortRecycler);
        
        sortRecycler();
    }

    private void sortRecycler() {
        sortRecycler.setHasFixedSize(true);
        sortRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<SortHelperClass> sortLocations = new ArrayList<>();
        sortLocations.add(new SortHelperClass(R.drawable.ic_controls1,""));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,"Бургеры"));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,"Суши"));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,"Пицца"));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,"Дессерты"));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,"Лапша WOK"));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,"Шаурма"));

        adapter = new SortAdapter(sortLocations);
        sortRecycler.setAdapter(adapter);
    }
}