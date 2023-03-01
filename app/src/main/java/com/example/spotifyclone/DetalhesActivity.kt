package com.example.spotifyclone

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spotifyclone.databinding.ActivityDetalhesBinding
import com.example.spotifyclone.fragments.Home

class DetalhesActivity : AppCompatActivity() {

  lateinit var binding: ActivityDetalhesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetalhesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val toolbar = binding.toolbar

    window.statusBarColor = Color.LTGRAY
    toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
    toolbar.setNavigationOnClickListener {
      val intent = Intent(this, Home::class.java)
      startActivities(intent)
      finish()
    }
  }

  private fun startActivities(intent: Intent) {
  }
}