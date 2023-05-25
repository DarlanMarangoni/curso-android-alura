package com.darlanmarangoni.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.darlanmarangoni.R

class FormularioProdutoActivity :
    AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val botaoSalvar = findViewById<Button>(R.id.btn_salvar)
        botaoSalvar.setOnClickListener {
            val txtNome = findViewById<EditText>(R.id.txt_nome)
            val nome = txtNome.text.toString()
            Log.i("FormularioProduto", "onCreate: $nome")
        }
    }

}