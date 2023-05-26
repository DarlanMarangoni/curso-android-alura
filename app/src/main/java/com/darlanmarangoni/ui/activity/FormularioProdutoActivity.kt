package com.darlanmarangoni.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.darlanmarangoni.R
import com.darlanmarangoni.dao.ProdutoDao
import com.darlanmarangoni.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar)
        val produtoDao = ProdutoDao()
        botaoSalvar.setOnClickListener {
            val produto = criaProduto()
            produtoDao.adiciona(produto)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val txtNome = findViewById<EditText>(R.id.txt_nome)
        val nome = txtNome.text.toString()
        val txtDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao)
        val descricao = txtDescricao.text.toString()
        val txtValor =
            findViewById<EditText>(R.id.activity_formulario_produto_valor).text.toString()
        val valor = if (txtValor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(txtValor)
        }
        return Produto(nome = nome, descricao = descricao, valor = valor)
    }

}