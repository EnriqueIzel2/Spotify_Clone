package com.example.spotifyclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spotifyclone.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

  lateinit var binding: ActivityDetalhesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetalhesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
  }
}