package com.example.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.CategoriaItemBinding
import com.example.spotifyclone.databinding.FragmentHomeBinding
import com.example.spotifyclone.model.Categoria

class Home : Fragment(R.layout.fragment_home) {

  private lateinit var categoriaAdapter: CategoriaAdapter

  companion object {

    @JvmStatic
    fun newInstance(): Home {
      val fragmentHome = Home()
      val arguments = Bundle()
      fragmentHome.arguments = arguments

      return fragmentHome
    }
  }

  private var fragmentHome: FragmentHomeBinding? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val bindingHome = FragmentHomeBinding.bind(view)
    fragmentHome = bindingHome
    val recyclerViewCategorias = bindingHome.recyclerViewCategorias

    val categorias: MutableList<Categoria> = ArrayList()
    for (c in 1..5) {
      val categoria = Categoria()
      categoria.titulo = "Categoria $c"

      categorias.add(categoria)
    }

    categoriaAdapter = CategoriaAdapter(categorias)
    recyclerViewCategorias.adapter = categoriaAdapter
    recyclerViewCategorias.layoutManager = LinearLayoutManager(context)

  }

  private inner class CategoriaAdapter(private val categorias: MutableList<Categoria>) :
    RecyclerView.Adapter<CategoriaHolder>() {

    private lateinit var binding: CategoriaItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
      binding = CategoriaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return CategoriaHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {
      val categoria = categorias[position]
      holder.bind(categoria)
    }

    override fun getItemCount(): Int = categorias.size
  }

  private inner class CategoriaHolder(binding: CategoriaItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val itemTitulo = binding.categoriaItemTitulo
    private val recyclerAlbuns = binding.categoriaItemRecyclerViewAlbuns

    fun bind(categoria: Categoria) {
      itemTitulo.text = categoria.titulo
    }
  }
}