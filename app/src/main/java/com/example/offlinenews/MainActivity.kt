package com.example.offlinenews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.offlinenews.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        replaceFragment(Home())

        val bottom_Navigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottom_Navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.cricket -> replaceFragment(Sports())
                R.id.profile -> replaceFragment(Profile())

                else ->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
    }
}