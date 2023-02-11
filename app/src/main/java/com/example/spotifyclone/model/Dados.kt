package com.example.spotifyclone.model

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