package com.example.spotifyclone.model

import com.example.spotifyclone.R
import com.google.gson.annotations.SerializedName

data class Categoria(
  @SerializedName("titulo") var titulo: String = "",
  @SerializedName("albuns") var albuns: List<Album> = arrayListOf()
)

data class Album(
  @SerializedName("url_imagem") var url_imagem: String = ""
)

data class Categorias(
  @SerializedName("categoria")
  val categorias: List<Categoria>
)

data class Secao(
  var secao: Int,
  var nomeSecao: String
)

class SecaoBuilder {
  var secao: Int = 0
  var nomeSecao: String = ""

  fun build(): Secao = Secao(secao, nomeSecao)
}

fun secao(block: SecaoBuilder.() -> Unit): Secao = SecaoBuilder().apply(block).build()

fun dados(): MutableList<Secao> = mutableListOf(
  secao {
    secao = R.drawable.secao1
    nomeSecao = "Podcasts"
  },
  secao {
    secao = R.drawable.secao2
    nomeSecao = "Lançamentos"
  },
  secao {
    secao = R.drawable.secao3
    nomeSecao = "Em casa"
  },
  secao {
    secao = R.drawable.secao4
    nomeSecao = "Paradas"
  },
  secao {
    secao = R.drawable.secao1
    nomeSecao = "Shows"
  },
  secao {
    secao = R.drawable.secao2
    nomeSecao = "Para Você"
  },
  secao {
    secao = R.drawable.secao3
    nomeSecao = "Malhação"
  },
  secao {
    secao = R.drawable.secao4
    nomeSecao = "MPB"
  },
)
