package com.darlanmarangoni.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.darlanmarangoni.R
import com.darlanmarangoni.dao.ProdutoDao
import com.darlanmarangoni.model.Produto
import com.darlanmarangoni.ui.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity: AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(this, ProdutoDao().buscaTodos())
        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add)
        fabAdd.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}