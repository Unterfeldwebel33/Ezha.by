package com.example.ezhaby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ezhaby.Helper.Classes.Home.Adapter.SortAdapter;
import com.example.ezhaby.Helper.Classes.Home.Adapter.SortHelperClass;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class FoodcourtActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Верхняя карусель сортировки
    RecyclerView sortRecycler;
    SortAdapter.RecyclerVievClickListener listener;
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
        setOnClickListener();
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

    //включение по нажатию нижнего модального окна и сортировка(не до конца готово)
    private void setOnClickListener() {
        listener = new SortAdapter.RecyclerVievClickListener() {
            @Override
            public void onClick(View v, int position) {

                //разбиты и по отдельности расписаны исключения для сортировок
                switch (position) {
                    case 0:

                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                            FoodcourtActivity.this, R.style.BottomSheet);
                    View bottomsheet = LayoutInflater.from(getApplicationContext())
                            .inflate(R.layout.bottom_sheet_sort_layout,
                                    (LinearLayout) findViewById(R.id.bottomSheetCont));

                    //Переходы на уровне модального окна
                    bottomsheet.findViewById(R.id.contLayoutTwo).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(FoodcourtActivity.this, "Пока не работает, скоро все будет", Toast.LENGTH_SHORT).show();
                        }
                    });

                    bottomsheet.findViewById(R.id.contLayoutThree).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(FoodcourtActivity.this, "Пока не работает, скоро все будет", Toast.LENGTH_SHORT).show();
                        }
                    });

                    bottomsheet.findViewById(R.id.contLayoutFour).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(FoodcourtActivity.this, "Пока не работает, скоро все будет", Toast.LENGTH_SHORT).show();
                        }
                    });

                    bottomSheetDialog.setContentView(bottomsheet);
                    bottomSheetDialog.show();

                    break;

                    case 1:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по бургерам", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по суши", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по пицце", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по дессертам", Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по лапше WOK", Toast.LENGTH_SHORT).show();
                        break;

                    case 6:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по Шаурме", Toast.LENGTH_SHORT).show();
                        break;

                    case 7:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по Маку", Toast.LENGTH_SHORT).show();
                        break;

                    case 8:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по КФС", Toast.LENGTH_SHORT).show();
                        break;

                    case 9:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по БК", Toast.LENGTH_SHORT).show();
                        break;

                    case 10:
                        Toast.makeText(FoodcourtActivity.this, "Сортировка по Салатерии", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
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

        adapter = new SortAdapter(sortLocations,listener);
        sortRecycler.setAdapter(adapter);

    }

}