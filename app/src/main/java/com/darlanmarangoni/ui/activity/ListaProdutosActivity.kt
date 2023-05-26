package com.darlanmarangoni.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.darlanmarangoni.R
import com.darlanmarangoni.dao.ProdutoDao
import com.darlanmarangoni.ui.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity: AppCompatActivity(R.layout.activity_lista_produtos) {

    val produtoDao = ProdutoDao()
    val adapter = ListaProdutosAdapter(this, produtoDao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(produtoDao.buscaTodos())
    }

    private fun configuraFab() {
        val fabAdd = findViewById<FloatingActionButton>(R.id.activity_lista_produtos_fab_add)
        fabAdd.setOnClickListener {
            vaiParaFormularioProdutos()
        }
    }

    private fun vaiParaFormularioProdutos() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_recyclerView)
        recyclerView.adapter = adapter
    }
}