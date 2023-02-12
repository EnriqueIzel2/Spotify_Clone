package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.spotifyclone.fragments.Biblioteca
import com.example.spotifyclone.fragments.Buscar
import com.example.spotifyclone.fragments.Home
import com.example.spotifyclone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private var content: FrameLayout? = null

  private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.menu_item_inicio -> {
        val fragment = Home.newInstance()
        addFragment(fragment)
        return@OnNavigationItemSelectedListener true
      }

      R.id.menu_item_buscar -> {
        val fragment = Buscar.newInstance()
        addFragment(fragment)
        return@OnNavigationItemSelectedListener true
      }

      R.id.menu_item_biblioteca -> {
        val fragment = Biblioteca.newInstance()
        addFragment(fragment)
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    content = binding.mainContent
    binding.bottomNavMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    val fragment = Home.newInstance()
    addFragment(fragment)
  }

  private fun addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.main_content, fragment, fragment.javaClass.simpleName)
      .commit()
  }
}