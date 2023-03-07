package com.example.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dictionary.databinding.ActivityMenuBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MenuActivity : AppCompatActivity(R.layout.activity_menu) {

    lateinit var bottomNavigation: BottomNavigationView
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadFragment(DictionaryFragment())
        bottomNavigation = binding.bottomNavigation

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dictionary -> {
                    loadFragment(DictionaryFragment())
                    true
                }
                R.id.training -> {
                    loadFragment(TrainingFragment())
                    true
                }
                else -> {
                    loadFragment(VideoFragment())
                    true
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}