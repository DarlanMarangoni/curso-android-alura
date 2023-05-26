package com.darlanmarangoni.dao

import com.darlanmarangoni.model.Produto

class ProdutoDao {

    companion object {
        val produtos = mutableListOf<Produto>()
    }

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos():List<Produto> {
        return produtos.toList()
    }

}