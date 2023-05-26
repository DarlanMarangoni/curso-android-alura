package com.darlanmarangoni.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.darlanmarangoni.R
import com.darlanmarangoni.dao.ProdutoDao
import com.darlanmarangoni.databinding.ActivityListaProdutosBinding
import com.darlanmarangoni.ui.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity: AppCompatActivity(R.layout.activity_lista_produtos) {

    private val produtoDao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(this, produtoDao.buscaTodos())
    private lateinit var binding: ActivityListaProdutosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(produtoDao.buscaTodos())
    }

    private fun configuraFab() {
        val fabAdd = binding.activityListaProdutosFabAdd
        fabAdd.setOnClickListener {
            vaiParaFormularioProdutos()
        }
    }

    private fun vaiParaFormularioProdutos() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter
    }
}