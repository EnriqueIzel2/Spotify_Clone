package com.example.spotifyclone.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.FragmentBibliotecaBinding
import com.example.spotifyclone.fragments.pagertab.Albuns
import com.example.spotifyclone.fragments.pagertab.Artistas
import com.example.spotifyclone.fragments.pagertab.Playlists
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class Biblioteca : Fragment(R.layout.fragment_biblioteca) {

  private lateinit var binding: FragmentBibliotecaBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    val bindingBiblioteca = FragmentBibliotecaBinding.bind(view)
    binding = bindingBiblioteca

    val viewPager = binding.viewpager
    val viewPagerTab = binding.viewpagertab

    super.onViewCreated(view, savedInstanceState)
    var adapter = FragmentPagerItemAdapter(
      fragmentManager, FragmentPagerItems.with(context)
        .add("Playlists", Playlists::class.java)
        .add("Artistas", Artistas::class.java)
        .add("Álbuns", Albuns::class.java)
        .create()
    )

    viewPager.adapter = adapter
    viewPagerTab.setViewPager(viewPager)
  }

  companion object {

    @JvmStatic
    fun newInstance() =
      Biblioteca().apply {
        arguments = Bundle()
      }
  }
}