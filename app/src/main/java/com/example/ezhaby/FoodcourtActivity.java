package com.example.ezhaby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.ezhaby.Helper.Classes.Home.Adapter.SortAdapter;
import com.example.ezhaby.Helper.Classes.Home.Adapter.SortHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class FoodcourtActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

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


    //Дает возможность перейти куда-нибудь из меню меню
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){

            case  R.id.nav_callback:
                startActivity(new Intent(getApplicationContext(), CallbackActivity.class));
                break;

            case  R.id.nav_about:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                break;
        }

        return true;
    }

    //отрисовка карусели сортировки
    private void sortRecycler() {
        sortRecycler.setHasFixedSize(true);
        sortRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<SortHelperClass> sortLocations = new ArrayList<>();
        sortLocations.add(new SortHelperClass(R.drawable.ic_controls1,""));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.Burgers)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.Sushi)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.Pizza)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.Desserts)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.WOK)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.Doner)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.McDonalds)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.KFC)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.BurgerKing)));
        sortLocations.add(new SortHelperClass(R.drawable.ic_fake,getString(R.string.Salateria)));


        adapter = new SortAdapter(sortLocations);
        sortRecycler.setAdapter(adapter);
    }

}