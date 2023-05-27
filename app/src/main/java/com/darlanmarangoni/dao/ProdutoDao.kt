package com.darlanmarangoni.dao

import com.darlanmarangoni.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    companion object {
        val produtos = mutableListOf<Produto>(
            Produto(
                nome = "cesta de frutas",
                descricao = "maça, laranja e banana",
                valor = BigDecimal("19.69")
            )
        )
    }

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos():List<Produto> {
        return produtos.toList()
    }

}