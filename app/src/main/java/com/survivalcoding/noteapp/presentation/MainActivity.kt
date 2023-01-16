package com.survivalcoding.noteapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.survivalcoding.noteapp.Config.Companion.EXTRA_KEY_FRAGMENT
import com.survivalcoding.noteapp.Config.Companion.FRAGMENT_CODE_ADD
import com.survivalcoding.noteapp.R
import com.survivalcoding.noteapp.databinding.ActivityMainBinding
import com.survivalcoding.noteapp.presentation.fragment.ListFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_fragment_container, ListFragment())
                .commit()
        }

        binding.addFab.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(EXTRA_KEY_FRAGMENT, FRAGMENT_CODE_ADD)
            }
            startActivity(intent)
        }
    }
}