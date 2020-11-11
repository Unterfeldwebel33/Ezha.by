package com.example.ezhaby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        if(user!=null){
            val ProfileIntent = Intent(this,ProfileActivity::class.java)
            startActivity(ProfileIntent)
            finish()
        }else{
            val SignIntent = Intent(this,SignActivity::class.java)
            startActivity(SignIntent)
            finish()
        }

    }

}