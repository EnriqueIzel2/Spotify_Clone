package com.example.spotifyclone

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.spotifyclone.databinding.ActivityDetalhesBinding
import com.example.spotifyclone.fragments.Home
import com.squareup.picasso.Picasso

class DetalhesActivity : AppCompatActivity() {

  lateinit var binding: ActivityDetalhesBinding
  lateinit var toolbar: Toolbar
  lateinit var detalhesImage: ImageView
  lateinit var title: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetalhesBinding.inflate(layoutInflater)
    setContentView(binding.root)

    initComponentsID()

    intent.extras?.let {
      val album = it.getString("album")
      Picasso.get().load(album).into(detalhesImage)
    }

    window.statusBarColor = Color.LTGRAY
    toolbar.navigationIcon = getDrawable(R.drawable.ic_arrow_back)
    toolbar.setNavigationOnClickListener {
      val intent = Intent(this, Home::class.java)
      startActivities(intent)
      finish()
    }
  }

  private fun initComponentsID() {
    toolbar = binding.toolbar
    detalhesImage = binding.activityDetalhesImage
    title = binding.activityDetalhesTitle
  }

  private fun startActivities(intent: Intent) {
  }
}