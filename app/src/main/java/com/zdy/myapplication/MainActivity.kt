package com.zdy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zdy.myapplication.Fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.place_holder,MainFragment.newInstance()).commit()
    }
}