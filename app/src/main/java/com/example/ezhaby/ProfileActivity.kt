package com.example.ezhaby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        current_user_name.text = currentUser?.displayName
        current_user_email.text = currentUser?.email

        logout.setOnClickListener{
            mAuth.signOut()
            val intent = Intent(this,FoodcourtActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}