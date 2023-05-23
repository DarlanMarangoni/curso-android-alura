package com.darlanmarangoni

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //definindo a view
        val textView = TextView(this)
        textView.text = "Cesta de frutas"
        //mostrando o conteúdo dentro da activity
        setContentView(textView)
    }
}