package com.example.spotifyclone.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.AlbumItemBinding
import com.example.spotifyclone.databinding.CategoriaItemBinding
import com.example.spotifyclone.databinding.FragmentHomeBinding
import com.example.spotifyclone.model.*
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    val categorias = arrayListOf<Categoria>()

    categoriaAdapter = CategoriaAdapter(categorias)
    recyclerViewCategorias.adapter = categoriaAdapter
    recyclerViewCategorias.layoutManager = LinearLayoutManager(context)

    initRetrofit().create(SpotifyAPI::class.java)
      .getCategorias()
      .enqueue(object : Callback<Categorias> {
        override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
          if (response.isSuccessful) {
            response.body()?.let {
              categoriaAdapter.categorias.clear()
              categoriaAdapter.categorias.addAll(it.categorias)
              categoriaAdapter.notifyDataSetChanged()
            }
          }
        }

        override fun onFailure(call: Call<Categorias>, t: Throwable) {
          Log.i("Home", "onFailure: falhou a requisição")
        }
      })
  }

  private inner class CategoriaAdapter(val categorias: MutableList<Categoria>) :
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
      recyclerAlbuns.adapter = AlbumAdapter(categoria.albuns)
      recyclerAlbuns.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }
  }

  private inner class AlbumAdapter(private val albuns: List<Album>) : RecyclerView.Adapter<AlbunsHolder>() {
    private lateinit var binding: AlbumItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbunsHolder {
      binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return AlbunsHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbunsHolder, position: Int) {
      val album = albuns[position]
      holder.bind(album)
    }

    override fun getItemCount(): Int = albuns.size
  }

  private inner class AlbunsHolder(binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val albumItemImage = binding.albumItemImage

    fun bind(album: Album) {
      Picasso.get().load(album.url_imagem).placeholder(R.drawable.placeholder).fit().into(albumItemImage)
    }
  }
}