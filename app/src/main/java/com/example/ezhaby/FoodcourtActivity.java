package com.example.ezhaby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ezhaby.Helper.Classes.Home.Adapter.SortAdapter;
import com.example.ezhaby.Helper.Classes.Home.Adapter.SortHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class FoodcourtActivity extends AppCompatActivity {

    //Верхняя карусель сортировки
    RecyclerView sortRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;

    //Боковое меню
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodcourt);

        //Ссылки на активити
        sortRecycler = findViewById(R.id.sortRecycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        //Вызов функций
        sortRecycler();
        navigationDrawer();
    }

    //отрисовка появления меню
    private void navigationDrawer() {
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });



    }

    //Закрытие меню по кнопке назад
    @Override
    public void onBackPressed(){

        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    //отрисовка карусели сортировки
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