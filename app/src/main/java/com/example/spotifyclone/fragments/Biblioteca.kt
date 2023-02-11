package com.example.spotifyclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spotifyclone.R

class Biblioteca : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_biblioteca, container, false)
  }

  companion object {

    @JvmStatic
    fun newInstance() =
      Biblioteca().apply {
        arguments = Bundle()
      }
  }
}