package com.darlanmarangoni.ui.activity

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.darlanmarangoni.R
import com.darlanmarangoni.dao.ProdutoDao
import com.darlanmarangoni.databinding.ActivityFormularioProdutoBinding
import com.darlanmarangoni.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity(R.layout.activity_formulario_produto) {

    private lateinit var binding: ActivityFormularioProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val produtoDao = ProdutoDao()
        botaoSalvar.setOnClickListener {
            val produto = criaProduto()
            produtoDao.adiciona(produto)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val txtNome = binding.activityFormularioProdutoNome
        val nome = txtNome.text.toString()
        val txtDescricao = binding.activityFormularioProdutoDescricao
        val descricao = txtDescricao.text.toString()
        val txtValor = binding.activityFormularioProdutoValor.text.toString()
        val valor = if (txtValor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(txtValor)
        }
        return Produto(nome = nome, descricao = descricao, valor = valor)
    }

}