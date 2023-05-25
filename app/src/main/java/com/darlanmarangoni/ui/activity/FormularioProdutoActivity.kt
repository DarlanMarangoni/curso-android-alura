package com.darlanmarangoni.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.darlanmarangoni.R
import com.darlanmarangoni.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val botaoSalvar = findViewById<Button>(R.id.btn_salvar)
        botaoSalvar.setOnClickListener {
            val txtNome = findViewById<EditText>(R.id.txt_nome)
            val nome = txtNome.text.toString()
            val txtDescricao = findViewById<EditText>(R.id.txt_descricao)
            val descricao = txtDescricao.text.toString()
            val txtValor = findViewById<EditText>(R.id.txt_valor).text.toString()
            val valor = if (txtValor.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(txtValor)
            }

            val produto = Produto(nome = nome, descricao = descricao, valor = valor)
            Log.i("FormularioProduto", "onCreate: $produto")
        }
    }

}