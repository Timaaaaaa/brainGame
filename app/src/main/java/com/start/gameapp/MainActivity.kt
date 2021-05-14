package com.start.gameapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.start.gameapp.presentation.home.HomeFragment
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val a : Retrofit by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, a.toString(), Toast.LENGTH_LONG).show()

        supportFragmentManager.beginTransaction().add(R.id.container, HomeFragment()).commit() // todo check it
    }
}