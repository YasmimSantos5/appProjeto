package com.example.projetoapp.activity

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoapp.R
import java.util.Calendar

class CadastroAutorizacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_autorizacao)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        val toolbarAutorizcao = findViewById<Toolbar>(R.id.toolbarAutorizacao)
        setSupportActionBar(toolbarAutorizcao)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val camponome = findViewById<EditText>(R.id.editTextNome)
        val campodocumento = findViewById<EditText>(R.id.editTextDocumento)
        val campoapartamento = findViewById<EditText>(R.id.editTextBloco)
        val campodata = findViewById<DatePicker>(R.id.datepickerAutorizacao)
        val textViewMensagem = findViewById<TextView>(R.id.textViewMensagem)

        val botaoAutorizacao = findViewById<Button>(R.id.buttonAutorizacao)

        botaoAutorizacao.setOnClickListener {

            val nome = camponome.text.toString().trim()
            val documento = campodocumento.text.toString().trim()
            val apartamento = campoapartamento.text.toString().trim()

            if (nome.isNotEmpty() && documento.isNotEmpty() && apartamento.isNotEmpty()) {

                textViewMensagem.text = "✓ Autorização Realizada"
                textViewMensagem.setBackgroundColor(Color.parseColor("#4CAF50"))
                textViewMensagem.visibility = View.VISIBLE

                // LIMPAR CAMPOS
                camponome.text.clear()
                campodocumento.text.clear()
                campoapartamento.text.clear()

                // RESETAR DATEPICKER
                val hoje = Calendar.getInstance()
                campodata.updateDate(
                    hoje.get(Calendar.YEAR),
                    hoje.get(Calendar.MONTH),
                    hoje.get(Calendar.DAY_OF_MONTH)
                )

            } else {

                textViewMensagem.text = "⚠ Preencha todos os campos"
                textViewMensagem.setBackgroundColor(Color.parseColor("#F44336"))
                textViewMensagem.visibility = View.VISIBLE
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}