package com.example.ezhaby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    TextView current_user_name, current_user_email;
    Button logout;
    ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        current_user_name = findViewById(R.id.current_user_name);
        current_user_email = findViewById(R.id.current_user_email);
        logout = findViewById(R.id.logout);
        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FoodcourtActivity.class));
            }
        });


        //подсос данных с гугл аккаунта

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!= null){
            current_user_name.setText(signInAccount.getDisplayName());
        }

        GoogleSignInAccount signInAccountE = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccountE!= null){
            current_user_email.setText(signInAccount.getEmail());
        }

        //выход из аккаунта
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), FoodcourtActivity.class));
            }
        });

    }
}