package com.example.spotifyclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.FragmentBuscarBinding
import com.example.spotifyclone.databinding.SecoesItemBinding
import com.example.spotifyclone.model.Secao
import com.example.spotifyclone.model.dados

class Buscar : Fragment() {

  private lateinit var secaoAdapter: SecaoAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_buscar, container, false)
  }

  private var binding: FragmentBuscarBinding? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val fragmentHome = FragmentBuscarBinding.bind(view)
    binding = fragmentHome
    val recyclerViewSecoes = fragmentHome.fragmentBuscarRecyclerView

    secaoAdapter = SecaoAdapter(dados())
    recyclerViewSecoes.adapter = secaoAdapter
    recyclerViewSecoes.layoutManager = GridLayoutManager(context, 2)
  }

  private inner class SecaoAdapter(private val secoes: MutableList<Secao>) : RecyclerView.Adapter<SecaoHolder>() {
    private lateinit var binding: SecoesItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecaoHolder {
      binding = SecoesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return SecaoHolder(binding)
    }

    override fun onBindViewHolder(holder: SecaoHolder, position: Int) {
      val secao = secoes[position]
      holder.bind(secao)
    }

    override fun getItemCount(): Int = secoes.size
  }

  private inner class SecaoHolder(binding: SecoesItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val itemImagem = binding.secoesItemImage
    private val itemTitle = binding.secoesItemTitle

    fun bind(secao: Secao) {
      itemImagem.setImageResource(secao.secao)
      itemTitle.text = secao.nomeSecao
    }
  }

  companion object {

    @JvmStatic
    fun newInstance() =
      Buscar().apply {
        arguments = Bundle()
      }
  }
}