package com.darlanmarangoni.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.darlanmarangoni.R
import com.darlanmarangoni.model.Produto
import com.darlanmarangoni.ui.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity: AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(this, listOf(
            Produto(
                nome = "teste 1",
                descricao = "teste desc 1",
                valor = BigDecimal("19.99")
            ),
            Produto(
                nome = "teste 2",
                descricao = "teste desc 2",
                valor = BigDecimal("29.99")
            ),
            Produto(
                nome = "teste 3",
                descricao = "teste desc 3",
                valor = BigDecimal("39.99")
            )
        ))
    }
}